package tinker.view.fish;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InformationView extends JFrame {

	public InformationView() {
		super("Tinker");
		setBounds(50, 50, 550, 500);
		setLayout(new GridLayout(1, 0));

		Color buttonsfg = new Color(230, 255, 230);
		Color buttonsbg = new Color(38, 77, 115);
		Color worldbg = new Color(25, 51, 77);

		setBackground(worldbg);

		TextArea texto = new TextArea("There are 5 houses in five different colors.\n"
				+ "In each house lives a person with a different nationality.\n"
				+ "These five owners drink a certain type of beverage, smoke a\n"
				+ " certain brand of cigar and keep a certain pet.\n"
				+ "No owners have the same pet, smoke the same brand of cigar\n" + " or drink the same beverage.\n"
				+ "Using theses information you should decide: Who owns the fish?\n"
				+ "+ The Brit lives in the red house.\n" + "+ The Swede has a dog.\n"
				+ "+ The Dane drinks tea.\n" + "+ The green house is on the left of the white house.\n"
				+ "+ The green house's owner drinks coffee.\n" + "+ The person who smokes Pall Mall has a bird.\n"
				+ "+ The owner of The yellow house smokes Dunhill.\n"
				+ "+ The man living in the center house drinks milk.\n" + "+ The Norwegian lives in the first house.\n"
				+ "+ The man who smokes blends lives next to the one who keeps a cat.\n"
				+ "+ The man who has a horse lives next to the man who smokes Dunhill.\n"
				+ "+ The owner who smokes BlueMaster drinks beer.\n" + "+ The German smokes Prince.\n"
				+ "+ The Norwegian lives next to the blue house.\n"
				+ "+ The man who smokes blend has a neighbor who drinks water.");

		texto.setFont(new Font("ariel", Font.PLAIN, 16));

		texto.setEditable(false);
		texto.setBackground(buttonsbg);
		texto.setForeground(buttonsfg);

		add(texto);
		setVisible(true);
	}

}
