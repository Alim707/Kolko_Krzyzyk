package kolko;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		JFrame ramka = new JFrame();
		Pan p = new Pan();
		ramka.add(p);

		ramka.setSize(800, 600);
		ramka.setLocationRelativeTo(null);
		ramka.setVisible(true);
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JOptionPane.showMessageDialog(null, "Tura kó³ek.");

	}

}
