package tinker.controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;

import tinker.model.bridge.character.*;
import tinker.model.bridge.game.*;
import tinker.view.StartView;
import tinker.view.bridge.BridgeView;

public class Controller implements MouseListener, BridgeListener {

	private StartView startView;
	private BridgeView bridgeView;

	private Runner slow;
	private Runner fast;

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
				bridgeView = new BridgeView();

				bridgeView.getBridge().setListener(this);

				bridgeView.getFlash().addMouseListener(this);
				bridgeView.getNormal().addMouseListener(this);
				bridgeView.getAthlete().addMouseListener(this);
				bridgeView.getTurtle().addMouseListener(this);
				bridgeView.getCross().addMouseListener(this);

				startView.setVisible(false);
			}
		} else if (e.getSource() instanceof JButton) {
			if (((JButton) e.getSource()).getName().equals("cross")) {
				bridgeView.getBridge().cross(slow, fast);
			} else if (((JButton) e.getSource()).getName().equals("flash")) {
				addRunner(bridgeView.getBridge().getFlash());
			} else if (((JButton) e.getSource()).getName().equals("turtle")) {
				addRunner(bridgeView.getBridge().getTurtle());
			} else if (((JButton) e.getSource()).getName().equals("athlete")) {
				addRunner(bridgeView.getBridge().getAthlete());
			} else if (((JButton) e.getSource()).getName().equals("normal")) {
				addRunner(bridgeView.getBridge().getNormal());
			}
		}

	}

	private void addRunner(Runner runner) {
		//TODO
		// change approach
		if (slow == null)
			slow = runner;
		else if (slow.isCrossed() == runner.isCrossed()) {
			if (slow.getTime() > runner.getTime())
				fast = runner;
			else {
				Runner tmp = slow;
				slow = runner;
				fast = tmp;
			}
		} else
			;
		// TODO
		// not same side
		
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
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void onBridgeEvent(BridgeEvent e) {
		bridgeView.update();
		if (e.getType() == BridgeEventType.WON) {
			bridgeView.won();
			bridgeView.setVisible(false);
			startView.setVisible(true);
		} else if (e.getType() == BridgeEventType.LOST) {
			bridgeView.lost();
			bridgeView.setVisible(false);
			startView.setVisible(true);
		} else if (e.getType() == BridgeEventType.CROSS)
			bridgeView.cross(e);
	}

}
