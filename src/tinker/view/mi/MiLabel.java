package tinker.view.mi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MiLabel extends JLabel {

	public MiLabel() {
		MiColors colors = new MiColors();
		setForeground(colors.getForeground());
	}

	public MiLabel(String text) {
		super(text);
		MiColors colors = new MiColors();
		setForeground(colors.getForeground());
	}

	public MiLabel(ImageIcon icon) {
		super(icon);
		MiColors colors = new MiColors();
		setForeground(colors.getForeground());
	}
}
