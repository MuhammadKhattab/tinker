package tinker.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import tinker.view.fish.FishView;
import tinker.view.mi.InformationView;
import tinker.view.mi.MiColors;

public class FishController implements MouseListener {

	private FishView fishView;
	private InformationView info;
	private MiColors color;

	public FishController() {
		fishView = new FishView();

		info = new InformationView(" There are 5 houses in five different colors.\n"
				+ " In each house lives a person with a different nationality.\n"
				+ " These five owners drink a certain type of beverage, smoke a certain brand of cigar and keep a certain pet.\n"
				+ " No owners have the same pet, smoke the same brand of cigar or drink the same beverage.\n"
				+ " Use the information to the right to decide: Who owns the fish?\n\n"
				+ " Note: the checkboxes on the right will not affect the solution and they are there\n"
				+ "  only to help in solving the puzzle.\n\n" + " These are links for the solution if you failed:\n"
				+ " https://www.youtube.com/watch?v=1rDVz_Fb6HQ\n" + " https://udel.edu/~os/riddle-solution.html\n");

		fishView.getHouse1().addMouseListener(this);
		fishView.getHouse2().addMouseListener(this);
		fishView.getHouse3().addMouseListener(this);
		fishView.getHouse4().addMouseListener(this);
		fishView.getHouse5().addMouseListener(this);
		fishView.getBack().addMouseListener(this);
		fishView.getInfo().addMouseListener(this);

		color = new MiColors();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() instanceof JButton) {
			if (((JButton) e.getSource()).getName().equals("back")) {
				back();
			} else if (((JButton) e.getSource()).getName().equals("info")) {
				info.setVisible(true);
			} else if (((JButton) e.getSource()).getName().equals("house1")) {
				wrong();
			} else if (((JButton) e.getSource()).getName().equals("house2")) {
				wrong();
			} else if (((JButton) e.getSource()).getName().equals("house3")) {
				wrong();
			} else if (((JButton) e.getSource()).getName().equals("house4")) {
				check();
			} else if (((JButton) e.getSource()).getName().equals("house5")) {
				wrong();
			}

		}
	}

	private void wrong() {
		JOptionPane.showMessageDialog(null, "No the fish is not there...");
	}

	private void check() {
		JOptionPane.showMessageDialog(null, "Yes the fish is in house #4...");
		if (correct1() && correct2() && correct3() && correct4() && correct5())
			JOptionPane.showMessageDialog(null, "and you have all clues correct! Great Job");
		else
			JOptionPane.showMessageDialog(null, "but you have to prove it... you didn't use the clues correctly...");
	}

	private boolean correct1() {
		return ((String) fishView.getColors1().getSelectedItem()).equals("Yellow")
				&& ((String) fishView.getNat1().getSelectedItem()).equals("Norwegian")
				&& ((String) fishView.getDrinks1().getSelectedItem()).equals("Water")
				&& ((String) fishView.getCigars1().getSelectedItem()).equals("Dunhill")
				&& ((String) fishView.getPets1().getSelectedItem()).equals("Cat");
	}

	private boolean correct2() {
		return ((String) fishView.getColors2().getSelectedItem()).equals("Blue")
				&& ((String) fishView.getNat2().getSelectedItem()).equals("Dane")
				&& ((String) fishView.getDrinks2().getSelectedItem()).equals("Tea")
				&& ((String) fishView.getCigars2().getSelectedItem()).equals("Blends")
				&& ((String) fishView.getPets2().getSelectedItem()).equals("Horse");
	}

	private boolean correct3() {
		return ((String) fishView.getColors3().getSelectedItem()).equals("Red")
				&& ((String) fishView.getNat3().getSelectedItem()).equals("Brit")
				&& ((String) fishView.getDrinks3().getSelectedItem()).equals("Milk")
				&& ((String) fishView.getCigars3().getSelectedItem()).equals("Pall Mall")
				&& ((String) fishView.getPets3().getSelectedItem()).equals("Bird");
	}

	private boolean correct4() {
		return ((String) fishView.getColors4().getSelectedItem()).equals("Green")
				&& ((String) fishView.getNat4().getSelectedItem()).equals("German")
				&& ((String) fishView.getDrinks4().getSelectedItem()).equals("Coffee")
				&& ((String) fishView.getCigars4().getSelectedItem()).equals("Prince")
				&& ((String) fishView.getPets4().getSelectedItem()).equals("Fish");
	}

	private boolean correct5() {
		return ((String) fishView.getColors5().getSelectedItem()).equals("White")
				&& ((String) fishView.getNat5().getSelectedItem()).equals("Swede")
				&& ((String) fishView.getDrinks5().getSelectedItem()).equals("Beer")
				&& ((String) fishView.getCigars5().getSelectedItem()).equals("BlueMaster")
				&& ((String) fishView.getPets5().getSelectedItem()).equals("Dog");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(color.getHover());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(color.getForeground());
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	public void back() {
		fishView.dispose();
		new Controller();
	}

}
