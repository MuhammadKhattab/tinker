package tinker.view.mi;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InformationView extends JFrame {

	public InformationView(String info) {
		super("Tinker");
		setBounds(150, 150, 800, 300);
		setLayout(new GridLayout(1, 0));

		MiColors color = new MiColors();

		setBackground(color.getDarkBackground());

		TextArea texto = new TextArea(info);

		texto.setFont(new Font("ariel", Font.PLAIN, 16));

		texto.setEditable(false);
		texto.setBackground(color.getDarkBackground());
		texto.setForeground(color.getForeground());

		add(texto);
		setVisible(true);
	}

}
