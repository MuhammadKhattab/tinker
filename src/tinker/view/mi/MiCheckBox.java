package tinker.view.mi;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class MiCheckBox extends JCheckBox {

	public MiCheckBox(String text) {
		super(text);
		MiColors color = new MiColors();
		setBackground(color.getBackground());
		setForeground(color.getForeground());
	}
}
