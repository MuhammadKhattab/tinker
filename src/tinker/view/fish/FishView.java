package tinker.view.fish;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tinker.model.fish.Game;
import tinker.view.WindowDestroyer;

@SuppressWarnings("serial")
public class FishView extends JFrame {

	private Game game;

	private JButton back;
	private JButton solve;
	private JButton info;

	private JPanel buttons;

	public FishView() {
		super("Tinker");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(50, 50, 800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowDestroyer());
		setLayout(new BorderLayout());

		game = new Game();
		Color buttonsbg = new Color(38, 77, 115);
		Color buttonsfg = new Color(230, 255, 230);
		Color worldbg = new Color(25, 51, 77);
		setBackground(worldbg);

		back = new JButton("Back");
		back.setName("back");
		back.setBackground(buttonsbg);
		back.setForeground(buttonsfg);

		solve = new JButton("Solve it");
		solve.setName("solve");
		solve.setBackground(buttonsbg);
		solve.setForeground(buttonsfg);

		info = new JButton("Available Information");
		info.setName("info");
		info.setBackground(buttonsbg);
		info.setForeground(buttonsfg);

		buttons = new JPanel(new GridLayout(0, 4));
		buttons.setBackground(new Color(25, 51, 77));

		buttons.add(info);
		buttons.add(solve);
		buttons.add(back);

		add(buttons, BorderLayout.SOUTH);

		setVisible(true);
	}

	public JButton getBack() {
		return back;
	}

	public JButton getSolve() {
		return solve;
	}

	public Game getGame() {
		return game;
	}

	public JButton getInfo() {
		return info;
	}
}
