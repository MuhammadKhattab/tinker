package tinker.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import tinker.model.bridge.character.Runner;
import tinker.model.bridge.game.BridgeEvent;
import tinker.model.bridge.game.BridgeEventType;
import tinker.model.bridge.game.BridgeListener;
import tinker.view.bridge.BridgeView;

public class BridgeController implements MouseListener, BridgeListener {

	private BridgeView bridgeView;

	public BridgeController() {
		bridgeView = new BridgeView();
		bridgeView.getBridge().setListener(this);

		bridgeView.getFlash().addMouseListener(this);
		bridgeView.getRabbit().addMouseListener(this);
		bridgeView.getSleepy().addMouseListener(this);
		bridgeView.getTurtle().addMouseListener(this);
		bridgeView.getCross().addMouseListener(this);
		bridgeView.getBack().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			if (((JButton) e.getSource()).getName().equals("cross")) {
				bridgeView.getBridge().cross();
			} else if (((JButton) e.getSource()).getName().equals("flash")) {
				addRunner(bridgeView.getBridge().getFlash());
			} else if (((JButton) e.getSource()).getName().equals("turtle")) {
				addRunner(bridgeView.getBridge().getTurtle());
			} else if (((JButton) e.getSource()).getName().equals("rabbit")) {
				addRunner(bridgeView.getBridge().getRabbit());
			} else if (((JButton) e.getSource()).getName().equals("sleepy")) {
				addRunner(bridgeView.getBridge().getSleepy());
			} else if (((JButton) e.getSource()).getName().equals("back")) {
				back();
			}
		}

	}

	public void back() {
		bridgeView.dispose();
		new Controller();
	}

	private void addRunner(Runner runner) {
		bridgeView.getBridge().addRunner(runner);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(0, 153, 115));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(230, 255, 230));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void onBridgeEvent(BridgeEvent e) {
		bridgeView.update(e);
		if (e.getType() == BridgeEventType.WON) {
			bridgeView.won();
			back();
		} else if (e.getType() == BridgeEventType.LOST) {
			bridgeView.lost();
			back();
		}
	}

}
