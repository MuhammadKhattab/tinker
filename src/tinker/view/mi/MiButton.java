package tinker.view.mi;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MiButton extends JButton {

	public MiButton() {
		MiColors colors = new MiColors();
		setForeground(colors.getForeground());
		setBackground(colors.getBackground());
	}

	public MiButton(String text) {
		super(text);
		MiColors colors = new MiColors();
		setForeground(colors.getForeground());
		setBackground(colors.getBackground());
	}

	public MiButton(ImageIcon icon) {
		super(icon);
		MiColors colors = new MiColors();
		setBackground(colors.getBackground());
		setForeground(colors.getForeground());
	}
}
