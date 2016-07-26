package tinker.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import tinker.model.bridge.character.Runner;
import tinker.model.bridge.game.BridgeEvent;
import tinker.model.bridge.game.BridgeEventType;
import tinker.model.bridge.game.BridgeListener;
import tinker.view.bridge.BridgeView;
import tinker.view.mi.InformationView;
import tinker.view.mi.MiColors;

public class BridgeController implements MouseListener, BridgeListener {

	private BridgeView bridgeView;
	private InformationView info;
	private MiColors color;

	public BridgeController() {
		bridgeView = new BridgeView();
		info = new InformationView(
				" All you have to do is cross with these 4 characters from danger side to safe side.\n"
						+ " - You can cross with max 2 at a time\n"
						+ " - Only the side that has the flash light can cross\n"
						+ " - Every character takes different amout of time to cross\n"
						+ " - They cross with the speed of the slowest\n" + " - You have to cross within 17 mins\n");

		bridgeView.getBridge().setListener(this);
		bridgeView.getFlash().addMouseListener(this);
		bridgeView.getRabbit().addMouseListener(this);
		bridgeView.getSleepy().addMouseListener(this);
		bridgeView.getTurtle().addMouseListener(this);
		bridgeView.getCross().addMouseListener(this);
		bridgeView.getBack().addMouseListener(this);
		bridgeView.getSolve().addMouseListener(this);
		bridgeView.getInfo().addMouseListener(this);

		color = new MiColors();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
			if (((JButton) e.getSource()).getName().equals("cross")) {
				bridgeView.getBridge().cross();
				bridgeView.clearChosen();
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
			} else if (((JButton) e.getSource()).getName().equals("solve")) {
				bridgeView.getBridge().solve();
			} else if (((JButton) e.getSource()).getName().equals("info")) {
				info.setVisible(true);
			}
		}

	}

	public void back() {
		bridgeView.dispose();
		new Controller();
	}

	private void addRunner(Runner runner) {
		bridgeView.getBridge().addRunner(runner);
		bridgeView.chose();
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
