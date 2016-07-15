package tinker.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import tinker.view.fish.FishView;
import tinker.view.fish.InformationView;

public class FishController implements MouseListener {

	private FishView fishView;

	public FishController() {
		fishView = new FishView();

		fishView.getBack().addMouseListener(this);
		fishView.getSolve().addMouseListener(this);
		fishView.getInfo().addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent() instanceof JButton) {
			if (((JButton) e.getSource()).getName().equals("back")) {
				back();
			} else if (((JButton) e.getSource()).getName().equals("solve")) {
				fishView.getGame().solve();
			}else if (((JButton) e.getSource()).getName().equals("info")) {
				new InformationView();
			}
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public void back() {
		fishView.dispose();
		new Controller();
	}

}
