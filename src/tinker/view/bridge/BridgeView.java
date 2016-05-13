package tinker.view.bridge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tinker.model.bridge.character.Flash;
import tinker.model.bridge.character.Runner;
import tinker.model.bridge.game.Bridge;
import tinker.model.bridge.game.BridgeEvent;
import tinker.view.WindowDestroyer;

@SuppressWarnings("serial")
public class BridgeView extends JFrame {

	private Bridge bridge;

	private JButton flash;
	private JButton athlete;
	private JButton normal;
	private JButton turtle;
	private JButton cross;

	private JPanel buttons;
	private JPanel world;
	private JPanel safe;
	private JPanel zombie;

	private JLabel flashSafe;
	private JLabel normalSafe;
	private JLabel turtleSafe;
	private JLabel athleteSafe;

	private JLabel passedTime;

	private JLabel flashZombie;
	private JLabel athleteZombie;
	private JLabel turtleZombie;
	private JLabel normalZombie;

	public BridgeView() {
		super("Tinker");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(50, 50, 800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowDestroyer());
		setLayout(new BorderLayout());

		bridge = new Bridge();

		flash = new JButton("1 min to cross");
		flash.setName("flash");
		flash.setBackground(new Color(204, 221, 255));

		athlete = new JButton("2 mins to cross");
		athlete.setName("athlete");
		athlete.setBackground(new Color(204, 221, 255));

		normal = new JButton("5 mins to cross");
		normal.setName("normal");
		normal.setBackground(new Color(204, 221, 255));

		turtle = new JButton("10 mins to cross");
		turtle.setName("turtle");
		turtle.setBackground(new Color(204, 221, 255));

		cross = new JButton("Cross");
		cross.setName("cross");
		cross.setBackground(new Color(204, 221, 255));

		buttons = new JPanel(new GridLayout(0, 4));
		buttons.setBackground(new Color(25, 51, 77));

		buttons.add(flash);
		buttons.add(athlete);
		buttons.add(normal);
		buttons.add(turtle);
		buttons.add(cross);

		normalSafe = new JLabel("Safe");

		athleteSafe = new JLabel("Safe");

		turtleSafe = new JLabel("Safe");

		flashSafe = new JLabel("Safe");

		safe = new JPanel(new GridLayout(4, 0));
		safe.setBackground(new Color(128, 170, 255));

		safe.add(flashSafe);
		safe.add(athleteSafe);
		safe.add(normalSafe);
		safe.add(turtleSafe);

		zombie = new JPanel(new GridLayout(4, 0));
		zombie.setBackground(new Color(128, 170, 255));

		normalZombie = new JLabel("Danger");

		athleteZombie = new JLabel("Danger");

		turtleZombie = new JLabel("Danger");

		flashZombie = new JLabel("Danger");

		zombie.add(flashZombie);
		zombie.add(athleteZombie);
		zombie.add(normalZombie);
		zombie.add(turtleZombie);

		world = new JPanel(new BorderLayout());
		world.setBackground(new Color(128, 170, 255));

		passedTime = new JLabel("Passed Time: " + bridge.getPassedTime());

		world.add(passedTime, BorderLayout.NORTH);
		world.add(safe, BorderLayout.EAST);
		world.add(zombie, BorderLayout.WEST);

		add(world, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

		setVisible(true);
	}

	public void update() {
		passedTime.setText("Passed Time: " + bridge.getPassedTime());
	}

	public Bridge getBridge() {
		return bridge;
	}

	public JButton getFlash() {
		return flash;
	}

	public JButton getAthlete() {
		return athlete;
	}

	public JButton getNormal() {
		return normal;
	}

	public JButton getTurtle() {
		return turtle;
	}

	public void cross(BridgeEvent e) {
		Runner slow = ((Runner) e.getSource());
		who(slow);
		Runner fast = e.getFast();
		who(fast);
	}
	
	public void who(Runner runner) {
		if(runner instanceof Flash) {
			
		}
	}

	public void won() {
		message("You won!");
	}

	public void lost() {
		message("You lost!");
	}

	public void message(String message) {
		JOptionPane.showMessageDialog(null, message);
		JOptionPane.showMessageDialog(null, "More Coming Soon");
	}

	public JButton getCross() {
		return cross;
	}

}
