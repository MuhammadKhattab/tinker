package tinker.view.fish.combo;

import javax.swing.JComboBox;

import tinker.view.mi.MiColors;

@SuppressWarnings("serial")
public class DrinksComboBox extends JComboBox<String> {

	public DrinksComboBox() {
		super(new String[] { "Milk", "Water", "Beer", "Coffee", "Tea" });
		MiColors colors = new MiColors();
		setBackground(colors.getGrey2());
		setForeground(colors.getForeground());
	}

}
