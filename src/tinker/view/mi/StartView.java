package tinker.view.mi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

		MiColors color = new MiColors();

		bridge = new JLabel("BRIDGE RIDDLE", JLabel.CENTER);
		bridge.setName("bridge");
		bridge.setIcon(new ImageIcon("resources/images/bridge/bridge.png"));
		bridge.setFont(new Font("ariel", Font.PLAIN, 20));
		bridge.setForeground(color.getForeground());

		fish = new JLabel("EINSTEIN'S RIDDLE", JLabel.CENTER);
		fish.setName("fish");
		fish.setIcon(new ImageIcon("resources/images/fish/fish.png"));
		fish.setFont(new Font("ariel", Font.PLAIN, 20));
		fish.setForeground(color.getForeground());

		pan = new JPanel();
		pan.setLayout(new GridLayout(4, 0));
		pan.setBackground(color.getDarkBackground());
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
