package tinker.view.bridge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tinker.model.bridge.character.Athlete;
import tinker.model.bridge.character.Flash;
import tinker.model.bridge.character.Normal;
import tinker.model.bridge.character.Runner;
import tinker.model.bridge.character.Turtle;
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
	private JButton back;

	private JPanel buttons;
	private JPanel world;
	private JPanel safe;
	private JPanel zombie;

	private JLabel flashSafe;
	private JLabel normalSafe;
	private JLabel turtleSafe;
	private JLabel athleteSafe;

	private JLabel passedTime;
	private JLabel safeSide;
	private JLabel zombieSide;

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
		Color buttonsbg = new Color(38, 77, 115);
		Color buttonsfg = new Color(230, 255, 230);
		Color worldbg = new Color(25, 51, 77);

		flash = new JButton("1 min to cross");
		flash.setName("flash");
		flash.setBackground(buttonsbg);
		flash.setForeground(buttonsfg);
		flash.setIcon(new ImageIcon("resources/images/bridge/flash.png"));

		athlete = new JButton("2 mins to cross");
		athlete.setName("athlete");
		athlete.setBackground(buttonsbg);
		athlete.setForeground(buttonsfg);
		athlete.setIcon(new ImageIcon("resources/images/bridge/athlete.png"));

		normal = new JButton("5 mins to cross");
		normal.setName("normal");
		normal.setBackground(buttonsbg);
		normal.setForeground(buttonsfg);
		normal.setIcon(new ImageIcon("resources/images/bridge/normal.png"));

		turtle = new JButton("10 mins to cross");
		turtle.setName("turtle");
		turtle.setBackground(buttonsbg);
		turtle.setForeground(buttonsfg);
		turtle.setIcon(new ImageIcon("resources/images/bridge/turtle.png"));

		cross = new JButton("Cross");
		cross.setName("cross");
		cross.setBackground(buttonsbg);
		cross.setForeground(buttonsfg);

		back = new JButton("Back");
		back.setName("back");
		back.setBackground(buttonsbg);
		back.setForeground(buttonsfg);

		buttons = new JPanel(new GridLayout(0, 4));
		buttons.setBackground(new Color(25, 51, 77));

		buttons.add(flash);
		buttons.add(athlete);
		buttons.add(normal);
		buttons.add(turtle);
		buttons.add(cross);
		buttons.add(back);

		normalSafe = new JLabel();

		athleteSafe = new JLabel();

		turtleSafe = new JLabel();

		flashSafe = new JLabel();

		safe = new JPanel(new GridLayout(5, 0));
		safe.setBackground(worldbg);

		safeSide = new JLabel("Safe Side");
		safeSide.setForeground(buttonsfg);

		safe.add(safeSide);
		safe.add(flashSafe);
		safe.add(athleteSafe);
		safe.add(normalSafe);
		safe.add(turtleSafe);

		zombie = new JPanel(new GridLayout(5, 0));
		zombie.setBackground(worldbg);

		normalZombie = new JLabel(new ImageIcon("resources/images/bridge/normal.png"));

		athleteZombie = new JLabel(new ImageIcon("resources/images/bridge/athlete.png"));

		turtleZombie = new JLabel(new ImageIcon("resources/images/bridge/turtle.png"));

		flashZombie = new JLabel(new ImageIcon("resources/images/bridge/flash.png"));

		zombieSide = new JLabel("Danger Side");
		zombieSide.setIcon(new ImageIcon("resources/images/bridge/light.png"));
		zombieSide.setForeground(buttonsfg);
		
		zombie.add(zombieSide);
		zombie.add(flashZombie);
		zombie.add(athleteZombie);
		zombie.add(normalZombie);
		zombie.add(turtleZombie);

		world = new JPanel(new BorderLayout());
		world.setBackground(worldbg);
		
		passedTime = new JLabel("Passed Time: 0/17");
		passedTime.setForeground(buttonsfg);

		world.add(passedTime, BorderLayout.NORTH);
		world.add(safe, BorderLayout.EAST);
		world.add(zombie, BorderLayout.WEST);

		add(world, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

		setVisible(true);
	}

	public void update(BridgeEvent e) {
		passedTime.setText(String.format("Passed Time: %d/17", bridge.getPassedTime()));
		Runner slow = ((Runner) e.getSource());
		cross(slow);
		Runner fast = e.getFast();
		cross(fast);
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

	public void cross(Runner runner) {
		if (runner instanceof Flash) {
			if (bridge.isFire()) {
				flashZombie.setIcon(null);
				flashSafe.setIcon(new ImageIcon("resources/images/bridge/flash.png"));
			} else {
				flashSafe.setIcon(null);
				flashZombie.setIcon(new ImageIcon("resources/images/bridge/flash.png"));
			}
		} else if (runner instanceof Turtle)
			if (bridge.isFire()) {
				turtleZombie.setIcon(null);
				turtleSafe.setIcon(new ImageIcon("resources/images/bridge/turtle.png"));
			} else {
				turtleSafe.setIcon(null);
				turtleZombie.setIcon(new ImageIcon("resources/images/bridge/turtle.png"));
			}
		else if (runner instanceof Athlete)
			if (bridge.isFire()) {
				athleteZombie.setIcon(null);
				athleteSafe.setIcon(new ImageIcon("resources/images/bridge/athlete.png"));
			} else {
				athleteSafe.setIcon(null);
				athleteZombie.setIcon(new ImageIcon("resources/images/bridge/athlete.png"));
			}
		else if (runner instanceof Normal)
			if (bridge.isFire()) {
				normalZombie.setIcon(null);
				normalSafe.setIcon(new ImageIcon("resources/images/bridge/normal.png"));
			} else {
				normalSafe.setIcon(null);
				normalZombie.setIcon(new ImageIcon("resources/images/bridge/normal.png"));
			}
		if (bridge.isFire()) {
			zombieSide.setIcon(null);
			safeSide.setIcon(new ImageIcon("resources/images/bridge/light.png"));
		} else {
			safeSide.setIcon(null);
			zombieSide.setIcon(new ImageIcon("resources/images/bridge/light.png"));
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
	}

	public JButton getCross() {
		return cross;
	}

	public JButton getBack() {
		return back;
	}

}
