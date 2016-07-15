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
		setBounds(50, 50, 550, 350);
		setLayout(new GridLayout(1, 0));

		Color buttonsfg = new Color(230, 255, 230);
		Color buttonsbg = new Color(38, 77, 115);
		Color worldbg = new Color(25, 51, 77);

		setBackground(worldbg);

		TextArea texto = new TextArea(
				"+ The Brit lives in The red house.\n"
				+ "+ The Swede keeps dogs as pets.\n"
				+ "+ The Dane drinks tea.\n"
				+ "+ The green house is on The left of The white house.\n"
				+ "+ The green house's owner drinks coffee.\n"
				+ "+ The person who smokes Pall Mall rears birds.\n"
				+ "+ The owner of The yellow house smokes Dunhill.\n"
				+ "+ The man living in The center house drinks milk.\n"
				+ "+ The Norwegian lives in The first house.\n"
				+ "+ The man who smokes blends lives next to The one who keeps cats.\n"
				+ "+ The man who keeps horses lives next to The man who smokes Dunhill.\n"
				+ "+ The owner who smokes BlueMaster drinks beer.\n"
				+ "+ The German smokes Prince.\n"
				+ "+ The Norwegian lives next to The blue house.\n"
				+ "+ The man who smokes blend has a neighbor who drinks water.");

		texto.setFont(new Font("ariel", Font.PLAIN, 16));

		texto.setEditable(false);
		texto.setBackground(buttonsbg);
		texto.setForeground(buttonsfg);

		add(texto);
		setVisible(true);
	}
	
}
