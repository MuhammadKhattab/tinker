package tinker.controller;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import tinker.view.*;

public class Controller implements MouseListener {

	private StartView startView;

	public Controller() {
		startView = new StartView();
		startView.getStartGame().addMouseListener(this);

	}

	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			if (((JLabel) e.getSource()).getName().equals("start")) {
				JOptionPane.showMessageDialog(null, "Coming Soon!");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(255, 51, 0));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(0, 26, 51));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
