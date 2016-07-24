package tinker.view.fish.mi;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MiLabel extends JLabel {
	public MiLabel(String text) {
		super(text);
		MiColors colors = new MiColors();
		setForeground(colors.getForeground());
	}
}
