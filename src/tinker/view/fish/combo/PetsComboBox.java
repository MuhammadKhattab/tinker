package tinker.view.fish.combo;

import javax.swing.JComboBox;

import tinker.view.mi.MiColors;

@SuppressWarnings("serial")
public class PetsComboBox extends JComboBox<String> {

	public PetsComboBox() {
		super(new String[] { "Dog", "Cat", "Horse", "Fish", "Bird" });
		MiColors colors = new MiColors();
		setBackground(colors.getGreen());
		setForeground(colors.getForeground());
	}

}
