
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class XOGameMain {

	public static void main(String[] args) {
		//tworzenie okna itd itp.
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//dodajemy okno
            	JFrame frame = new JFrame ("Gra: Kó³ko 'O' i Krzy¿yk 'X'");
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setMinimumSize(new Dimension(500,500));
        		
        		//dodajemy panel
        		XOPanel panel = new XOPanel();
        		frame.getContentPane().add(panel, BorderLayout.CENTER);
        		        		
        		frame.pack();
        		frame.setVisible(true);
            	
            }
        });
	}

}
