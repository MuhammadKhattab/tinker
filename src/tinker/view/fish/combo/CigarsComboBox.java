package tinker.view.fish.combo;

import javax.swing.JComboBox;

import tinker.view.mi.MiColors;

@SuppressWarnings("serial")
public class CigarsComboBox extends JComboBox<String> {

	public CigarsComboBox() {
		super(new String[] { "Prince", "Pall Mall", "Blends", "Dunhill", "BlueMaster" });
		MiColors colors = new MiColors();
		setBackground(colors.getGrey());
		setForeground(colors.getForeground());
	}

}
