package tinker.view.bridge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tinker.model.bridge.character.Flash;
import tinker.model.bridge.character.Rabbit;
import tinker.model.bridge.character.Runner;
import tinker.model.bridge.character.Sleepy;
import tinker.model.bridge.character.Turtle;
import tinker.model.bridge.game.Bridge;
import tinker.model.bridge.game.BridgeEvent;
import tinker.view.mi.MiButton;
import tinker.view.mi.MiLabel;
import tinker.view.mi.WindowDestroyer;

@SuppressWarnings("serial")
public class BridgeView extends JFrame {

	private Bridge bridge;

	private MiButton flash;
	private MiButton rabbit;
	private MiButton sleepy;
	private MiButton turtle;
	private MiButton cross;
	private MiButton back;
	private MiButton solve;
	private MiButton info;

	private JPanel buttons;
	private JPanel world;
	private JPanel safe;
	private JPanel zombie;
	private JPanel upper;

	private MiLabel flashSafe;
	private MiLabel sleepySafe;
	private MiLabel turtleSafe;
	private MiLabel rabbitSafe;

	private MiLabel passedTime;
	private MiLabel chosen1Icon;
	private MiLabel chosen2Icon;

	private MiLabel safeSide;
	private MiLabel zombieSide;

	private MiLabel flashZombie;
	private MiLabel rabbitZombie;
	private MiLabel turtleZombie;
	private MiLabel sleepyZombie;

	public BridgeView() {
		super("Tinker");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(50, 50, 800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowDestroyer());
		setLayout(new BorderLayout());

		bridge = new Bridge();
		Color buttonsfg = new Color(230, 255, 230);
		Color worldbg = new Color(25, 51, 77);

		flash = new MiButton("1 min to cross");
		flash.setName("flash");
		flash.setIcon(new ImageIcon("resources/images/bridge/flash.png"));

		rabbit = new MiButton("2 mins to cross");
		rabbit.setName("rabbit");
		rabbit.setIcon(new ImageIcon("resources/images/bridge/rabbit.png"));

		sleepy = new MiButton("5 mins to cross");
		sleepy.setName("sleepy");
		sleepy.setIcon(new ImageIcon("resources/images/bridge/sleepy.png"));

		turtle = new MiButton("10 mins to cross");
		turtle.setName("turtle");
		turtle.setIcon(new ImageIcon("resources/images/bridge/turtle.png"));

		cross = new MiButton("Cross");
		cross.setName("cross");
		cross.setIcon(new ImageIcon("resources/images/general/cross.png"));

		back = new MiButton("Back");
		back.setName("back");
		back.setIcon(new ImageIcon("resources/images/general/back.png"));

		solve = new MiButton("Solve it");
		solve.setName("solve");
		solve.setIcon(new ImageIcon("resources/images/general/solve.png"));

		info = new MiButton("Available Information");
		info.setName("info");
		info.setIcon(new ImageIcon("resources/images/general/info.png"));

		buttons = new JPanel(new GridLayout(0, 4));
		buttons.setBackground(new Color(25, 51, 77));

		buttons.add(flash);
		buttons.add(rabbit);
		buttons.add(sleepy);
		buttons.add(turtle);
		buttons.add(cross);
		buttons.add(info);
		buttons.add(solve);
		buttons.add(back);

		sleepySafe = new MiLabel();

		rabbitSafe = new MiLabel();

		turtleSafe = new MiLabel();

		flashSafe = new MiLabel();

		safe = new JPanel(new GridLayout(5, 0));
		safe.setBackground(worldbg);

		safeSide = new MiLabel("Safe Side");
		safeSide.setForeground(buttonsfg);

		safe.add(safeSide);
		safe.add(flashSafe);
		safe.add(rabbitSafe);
		safe.add(sleepySafe);
		safe.add(turtleSafe);

		zombie = new JPanel(new GridLayout(5, 0));
		zombie.setBackground(worldbg);

		sleepyZombie = new MiLabel(new ImageIcon("resources/images/bridge/sleepy.png"));

		rabbitZombie = new MiLabel(new ImageIcon("resources/images/bridge/rabbit.png"));

		turtleZombie = new MiLabel(new ImageIcon("resources/images/bridge/turtle.png"));

		flashZombie = new MiLabel(new ImageIcon("resources/images/bridge/flash.png"));

		zombieSide = new MiLabel("Danger Side");
		zombieSide.setIcon(new ImageIcon("resources/images/bridge/light.png"));
		zombieSide.setForeground(buttonsfg);

		zombie.add(zombieSide);
		zombie.add(flashZombie);
		zombie.add(rabbitZombie);
		zombie.add(sleepyZombie);
		zombie.add(turtleZombie);

		world = new JPanel(new BorderLayout());
		world.setBackground(worldbg);

		passedTime = new MiLabel("Passed Time: 0/17");
		passedTime.setForeground(buttonsfg);

		chosen1Icon = new MiLabel("Chosen #1");
		chosen1Icon.setForeground(buttonsfg);

		chosen2Icon = new MiLabel("Chosen #2");
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

	public MiButton getFlash() {
		return flash;
	}

	public MiButton getRabbit() {
		return rabbit;
	}

	public MiButton getSleepy() {
		return sleepy;
	}

	public MiButton getTurtle() {
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

	public MiButton getCross() {
		return cross;
	}

	public MiButton getBack() {
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

	public MiButton getSolve() {
		return solve;
	}

	public MiButton getInfo() {
		return info;
	}
}
