package tinker.view.fish;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SolutionView extends JFrame {

	public SolutionView() {
		super("Tinker");
		setBounds(50, 50, 550, 150);
		setLayout(new GridLayout(1, 0));

		Color buttonsfg = new Color(230, 255, 230);
		Color buttonsbg = new Color(38, 77, 115);
		Color worldbg = new Color(25, 51, 77);

		setBackground(worldbg);

		TextArea texto = new TextArea("The Fish is in House #4\n" + "https://udel.edu/~os/riddle-solution.html\n"
				+ "https://www.youtube.com/watch?v=1rDVz_Fb6HQ");

		texto.setFont(new Font("ariel", Font.PLAIN, 16));

		texto.setEditable(false);
		texto.setBackground(buttonsbg);
		texto.setForeground(buttonsfg);

		add(texto);
		setVisible(true);
	}
	
}
