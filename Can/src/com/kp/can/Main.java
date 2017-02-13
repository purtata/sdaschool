package com.kp.can;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Throwable {

		List<Signal> definedSignals = loadSignalDefinitions("Files/signal.txt"); // definitions

		BufferedReader src = new BufferedReader(new FileReader("Files/can.txt")); // examples of read signals in time

		String readSignal;
		while ((readSignal = src.readLine()) != null) {
			String signalName = readSignal.split(" ")[1];
			int value = Integer.parseInt(readSignal.split(" ")[2]);

			Signal signal = findSignal(definedSignals, signalName);

			System.out.print(readSignal);
			if (!(signal.inRange(value))) {
				System.out.print(" Warning!");
			}
			System.out.println();
		}
		try {
			src.close();
		} catch (Exception e) {
			System.out.println("There was a problem: " + e);
			e.printStackTrace();
		}
	}

	private static Signal findSignal(List<Signal> definedSignals, String signalName) {
		Signal signal = null;
		for (Signal s : definedSignals) {
			if (s.getName().equals(signalName)) {
				signal = s;
			}
		}
		return signal;
	}

	private static List<Signal> loadSignalDefinitions(String path) {
		List<Signal> definedSignals = new ArrayList<>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(path));
			String read = null;
			while ((read = in.readLine()) != null) {
				String[] splited = read.split("\\s+");
				switch (splited[0]) {
				case "TEMP":
					Tmp signalTmp = new Tmp();
					signalTmp.setMin(Integer.parseInt(splited[1]));
					signalTmp.setMax(Integer.parseInt(splited[2]));
					definedSignals.add(signalTmp);
					break;
				case "RPM":
					Rpm signalRpm = new Rpm();
					signalRpm.setMin(Integer.parseInt(splited[1]));
					signalRpm.setMax(Integer.parseInt(splited[2]));
					definedSignals.add(signalRpm);
					break;
				case "FUEL":
					Fuel signalFuel = new Fuel();
					signalFuel.setMin(Integer.parseInt(splited[1]));
					signalFuel.setMax(Integer.parseInt(splited[2]));
					definedSignals.add(signalFuel);
					break;
				default:
					System.out.println("No recognized signal");
				}

			}
		} catch (IOException e) {
			System.out.println("There was a problem: " + e);
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				System.out.println("There was a problem: " + e);
				e.printStackTrace();
			}
		}

		return definedSignals;
	}
}
