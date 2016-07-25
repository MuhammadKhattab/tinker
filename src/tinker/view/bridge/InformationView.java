package tinker.view.bridge;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InformationView extends JFrame {

	public InformationView() {
		super("Tinker");
		setBounds(50, 50, 700, 200);
		setLayout(new GridLayout(1, 0));

		Color buttonsfg = new Color(230, 255, 230);
		Color buttonsbg = new Color(38, 77, 115);
		Color worldbg = new Color(25, 51, 77);

		setBackground(worldbg);

		TextArea texto = new TextArea(
				" All you have to do is cross with these 4 characters from the left side to the right side\n"
				+ " but every time you go you have to return with someone to bring the others that character\n"
				+ " will be holding a flash light and only the side that has a flash light can move");

		texto.setFont(new Font("ariel", Font.PLAIN, 16));

		texto.setEditable(false);
		texto.setBackground(buttonsbg);
		texto.setForeground(buttonsfg);

		add(texto);
		setVisible(true);
	}

}
