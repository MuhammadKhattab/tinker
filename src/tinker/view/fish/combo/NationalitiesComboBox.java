package tinker.view.fish.combo;

import javax.swing.JComboBox;

import tinker.view.fish.mi.MiColors;

@SuppressWarnings("serial")
public class NationalitiesComboBox extends JComboBox<String> {

	public NationalitiesComboBox() {
		super(new String[] { "Brit", "Norwegian", "Swede", "Dane", "German" });
		MiColors colors = new MiColors();
		setBackground(colors.getPurple());
		setForeground(colors.getForeground());
		
	}

}
