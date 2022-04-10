package kolko;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Action implements ActionListener {
	private Przycisk przycisk;
	private Pan panel;

	public Action(Przycisk przycisk, Pan panel) {
		this.przycisk = przycisk;
		this.panel = panel;
	}

	public void dzialanie() {
		switch (panel.sprawdz()) {
		case 0:
			JOptionPane.showMessageDialog(null, "Kó³ka wygrywaj¹");
			panel.czyscwysztko();
			break;

		case 1:
			JOptionPane.showMessageDialog(null, "Krzy¿yki wygrywaj¹");
			panel.czyscwysztko();
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Remis");
			panel.czyscwysztko();
			break;

		default:
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (przycisk.znak == 2) {
			if (panel.tura) {
				przycisk.zmianao();
				panel.tura = false;
				dzialanie();
				// JOptionPane.showMessageDialog(null, "Tura krzy¿yków.");

			} else {
				przycisk.zmianax();
				panel.tura = true;
				dzialanie();
				// JOptionPane.showMessageDialog(null, "Tura kó³ek.");

			}

		}

	}

}
