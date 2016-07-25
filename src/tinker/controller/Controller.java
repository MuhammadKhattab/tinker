package tinker.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import tinker.view.mi.StartView;

public class Controller implements MouseListener {
	private StartView startView;

	public Controller() {
		startView = new StartView();
		startView.getBridge().addMouseListener(this);
		startView.getFish().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (((JLabel) e.getSource()).getName().equals("bridge")) {
			new BridgeController();
			startView.dispose();
		} else {
			if (((JLabel) e.getSource()).getName().equals("fish")) {
				new FishController();
				startView.dispose();
			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(0, 153, 115));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(51, 51, 51));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	public static void main(String[] args) {
		new Controller();
	}
}
