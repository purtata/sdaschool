package app;

import dbutils.MySQLDAO;

import javax.swing.*;
import java.awt.*;


public class DBMainApp {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                //tworzymy okno
                JFrame frame = new JFrame("Data Base Explorator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //dodajemy do okna
                MySQLDAO dao = new MySQLDAO();
                DataTable table = new DataTable(dao);
                ExplorerPanel exPanel = new ExplorerPanel(table,dao);

                frame.getContentPane().add(exPanel, BorderLayout.LINE_START);
                frame.getContentPane().add(table, BorderLayout.CENTER);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
