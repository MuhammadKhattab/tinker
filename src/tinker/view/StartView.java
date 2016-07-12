package tinker.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class StartView extends JFrame {

	private JLabel bridge;
	private JLabel fish;

	private JPanel pan;

	public StartView() {
		super("Tinker");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(50, 50, 800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowDestroyer());
		setLayout(new BorderLayout());

		bridge = new JLabel("BRIDGE RIDDLE", JLabel.CENTER);
		bridge.setName("bridge");
		bridge.setIcon(new ImageIcon("resources/images/bridge.png"));
		bridge.setFont(new Font("ariel", Font.BOLD, 30));
		bridge.setForeground(new Color(51, 51, 51));

		fish = new JLabel("EINSTEIN'S RIDDLE", JLabel.CENTER);
		fish.setName("fish");
		fish.setIcon(new ImageIcon("resources/images/fish.png"));
		fish.setFont(new Font("ariel", Font.BOLD, 30));
		fish.setForeground(new Color(51, 51, 51));

		pan = new JPanel();
		pan.setLayout(new GridLayout(6, 0));
		pan.setBackground(new Color(163, 194, 194));
		pan.add(bridge);
		pan.add(fish);

		add(pan);
		setVisible(true);
	}

	public JLabel getBridge() {
		return bridge;
	}

	public JLabel getFish() {
		return fish;
	}
}
