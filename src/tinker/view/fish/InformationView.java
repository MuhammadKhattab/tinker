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
		setBounds(50, 50, 800, 200);
		setLayout(new GridLayout(1, 0));

		Color buttonsfg = new Color(230, 255, 230);
		Color buttonsbg = new Color(38, 77, 115);
		Color worldbg = new Color(25, 51, 77);

		setBackground(worldbg);

		TextArea texto = new TextArea(" There are 5 houses in five different colors.\n"
				+ " In each house lives a person with a different nationality.\n"
				+ " These five owners drink a certain type of beverage, smoke a certain brand of cigar and keep a certain pet.\n"
				+ " No owners have the same pet, smoke the same brand of cigar or drink the same beverage.\n"
				+ " Using theses information you should decide: Who owns the fish?");

		texto.setFont(new Font("ariel", Font.PLAIN, 16));

		texto.setEditable(false);
		texto.setBackground(buttonsbg);
		texto.setForeground(buttonsfg);

		add(texto);
		setVisible(true);
	}
	
}
