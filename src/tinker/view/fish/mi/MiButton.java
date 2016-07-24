package tinker.view.fish.mi;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MiButton extends JButton {

	public MiButton(String text) {
		super(text);
		MiColors colors = new MiColors();
		setForeground(colors.getForeground());
		setBackground(colors.getBackground());
	}
}
