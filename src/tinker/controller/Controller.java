package tinker.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import tinker.view.mi.MiColors;
import tinker.view.mi.StartView;

public class Controller implements MouseListener {
	private StartView startView;
	private MiColors color;

	public Controller() {
		startView = new StartView();
		startView.getBridge().addMouseListener(this);
		startView.getFish().addMouseListener(this);

		color = new MiColors();
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
		e.getComponent().setForeground(color.getHover());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(color.getForeground());
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
