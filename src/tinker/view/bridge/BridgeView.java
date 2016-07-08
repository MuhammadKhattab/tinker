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

import tinker.model.bridge.character.Rabbit;
import tinker.model.bridge.character.Flash;
import tinker.model.bridge.character.Sleepy;
import tinker.model.bridge.character.Runner;
import tinker.model.bridge.character.Turtle;
import tinker.model.bridge.game.Bridge;
import tinker.model.bridge.game.BridgeEvent;
import tinker.view.WindowDestroyer;

@SuppressWarnings("serial")
public class BridgeView extends JFrame {

	private Bridge bridge;

	private JButton flash;
	private JButton rabbit;
	private JButton sleepy;
	private JButton turtle;
	private JButton cross;
	private JButton back;

	private JPanel buttons;
	private JPanel world;
	private JPanel safe;
	private JPanel zombie;
	private JPanel upper;

	private JLabel flashSafe;
	private JLabel sleepySafe;
	private JLabel turtleSafe;
	private JLabel rabbitSafe;

	private JLabel passedTime;
	private JLabel chosen1Icon;
	private JLabel chosen2Icon;

	private JLabel safeSide;
	private JLabel zombieSide;

	private JLabel flashZombie;
	private JLabel rabbitZombie;
	private JLabel turtleZombie;
	private JLabel sleepyZombie;

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

		rabbit = new JButton("2 mins to cross");
		rabbit.setName("rabbit");
		rabbit.setBackground(buttonsbg);
		rabbit.setForeground(buttonsfg);
		rabbit.setIcon(new ImageIcon("resources/images/bridge/rabbit.png"));

		sleepy = new JButton("5 mins to cross");
		sleepy.setName("sleepy");
		sleepy.setBackground(buttonsbg);
		sleepy.setForeground(buttonsfg);
		sleepy.setIcon(new ImageIcon("resources/images/bridge/sleepy.png"));

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
		buttons.add(rabbit);
		buttons.add(sleepy);
		buttons.add(turtle);
		buttons.add(cross);
		buttons.add(back);

		sleepySafe = new JLabel();

		rabbitSafe = new JLabel();

		turtleSafe = new JLabel();

		flashSafe = new JLabel();

		safe = new JPanel(new GridLayout(5, 0));
		safe.setBackground(worldbg);

		safeSide = new JLabel("Safe Side");
		safeSide.setForeground(buttonsfg);

		safe.add(safeSide);
		safe.add(flashSafe);
		safe.add(rabbitSafe);
		safe.add(sleepySafe);
		safe.add(turtleSafe);

		zombie = new JPanel(new GridLayout(5, 0));
		zombie.setBackground(worldbg);

		sleepyZombie = new JLabel(new ImageIcon("resources/images/bridge/sleepy.png"));

		rabbitZombie = new JLabel(new ImageIcon("resources/images/bridge/rabbit.png"));

		turtleZombie = new JLabel(new ImageIcon("resources/images/bridge/turtle.png"));

		flashZombie = new JLabel(new ImageIcon("resources/images/bridge/flash.png"));

		zombieSide = new JLabel("Danger Side");
		zombieSide.setIcon(new ImageIcon("resources/images/bridge/light.png"));
		zombieSide.setForeground(buttonsfg);

		zombie.add(zombieSide);
		zombie.add(flashZombie);
		zombie.add(rabbitZombie);
		zombie.add(sleepyZombie);
		zombie.add(turtleZombie);

		world = new JPanel(new BorderLayout());
		world.setBackground(worldbg);

		passedTime = new JLabel("Passed Time: 0/17");
		passedTime.setForeground(buttonsfg);

		chosen1Icon = new JLabel("Chosen #1");
		chosen1Icon.setForeground(buttonsfg);

		chosen2Icon = new JLabel("Chosen #2");
		chosen2Icon.setForeground(buttonsfg);

		upper = new JPanel(new GridLayout(0, 3));
		upper.setBackground(worldbg);

		upper.add(passedTime);
		upper.add(chosen1Icon);
		upper.add(chosen2Icon);

		world.add(upper, BorderLayout.NORTH);
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

	public JButton getRabbit() {
		return rabbit;
	}

	public JButton getSleepy() {
		return sleepy;
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
		else if (runner instanceof Rabbit)
			if (bridge.isFire()) {
				rabbitZombie.setIcon(null);
				rabbitSafe.setIcon(new ImageIcon("resources/images/bridge/rabbit.png"));
			} else {
				rabbitSafe.setIcon(null);
				rabbitZombie.setIcon(new ImageIcon("resources/images/bridge/rabbit.png"));
			}
		else if (runner instanceof Sleepy)
			if (bridge.isFire()) {
				sleepyZombie.setIcon(null);
				sleepySafe.setIcon(new ImageIcon("resources/images/bridge/sleepy.png"));
			} else {
				sleepySafe.setIcon(null);
				sleepyZombie.setIcon(new ImageIcon("resources/images/bridge/sleepy.png"));
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

	public void chose() {
		if (bridge.getFast() == null) {
			chosen1Icon.setIcon(new ImageIcon("resources/images/bridge/" + getRunnerIcon(bridge.getSlow())));
			chosen2Icon.setIcon(null);
		} else {
			chosen1Icon.setIcon(new ImageIcon("resources/images/bridge/" + getRunnerIcon(bridge.getSlow())));
			chosen2Icon.setIcon(new ImageIcon("resources/images/bridge/" + getRunnerIcon(bridge.getFast())));
		}

	}

	public String getRunnerIcon(Runner runner) {
		if (runner instanceof Flash)
			return "flash.png";
		if (runner instanceof Turtle)
			return "turtle.png";
		if (runner instanceof Sleepy)
			return "sleepy.png";
		if (runner instanceof Rabbit)
			return "rabbit.png";
		return "";
	}

	public void clearChosen() {
		chosen1Icon.setIcon(null);
		chosen2Icon.setIcon(null);
	}

}
