package kolko;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 *
 */
public class Przycisk extends JButton {
	//0,1,2 albo enumeracja, albo stale!
	
	/**
	 * 	
	 * @author algie_000
	 *
	 */
	public enum OX {
		o,x,czysty
	}
	public int znak;

	public Przycisk() {
		znak = 2;

	}

	public void zmianao() {
		this.setIcon(new ImageIcon(((new ImageIcon("o.png").getImage().getScaledInstance(this.getWidth(),
				this.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		znak = 0;

	}

	public void zmianax() {
		this.setIcon(new ImageIcon(((new ImageIcon("x.png").getImage().getScaledInstance(this.getWidth(),
				this.getHeight(), java.awt.Image.SCALE_SMOOTH)))));
		znak = 1;

	}

	public void czysc() {
		this.setIcon(null);
		znak = 2;

	}

}
