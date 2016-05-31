package tinker.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class StartView extends JFrame {

	private JLabel startGame;

	private JPanel pan;

	public StartView() {
		super("Tinker");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(50, 50, 800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowDestroyer());
		setLayout(new BorderLayout());

		startGame = new JLabel("BRIDGE RIDDLE", JLabel.CENTER);
		startGame.setName("bridge");
		startGame.setIcon(new ImageIcon("resources/images/start.png"));
		startGame.setFont(new Font("ariel", Font.BOLD, 40));
		startGame.setForeground(new Color(51, 51, 51));

		pan = new JPanel();
		pan.setLayout(new GridLayout(4, 0));
		pan.setBackground(new Color(163, 194, 194));
		pan.add(startGame);

		add(pan);
		setVisible(true);
	}

	public JLabel getStartGame() {
		return startGame;
	}

}
