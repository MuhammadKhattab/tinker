package tinker.model.bridge.game;

import javax.swing.JOptionPane;

import tinker.model.bridge.character.*;

public class Bridge {

	private int AVAILABLE_TIME = 17;
	private int passedTime;
	private boolean fire;

	private Flash flash;
	private Normal normal;
	private Turtle turtle;
	private Athlete athlete;

	private Runner slow;
	private Runner fast;

	private BridgeListener listener;

	public Bridge() {
		normal = new Normal();
		flash = new Flash();
		turtle = new Turtle();
		athlete = new Athlete();
	}

	public void setSlow(Runner slow) {
		this.slow = slow;
	}

	public void setFast(Runner fast) {
		this.fast = fast;
	}

	public void clear() {
		slow = fast = null;
	}

	public void addRunner(Runner runner) {
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
			clear();
	}

	public boolean isFire() {
		return fire;
	}

	public Flash getFlash() {
		return flash;
	}

	public Normal getNormal() {
		return normal;
	}

	public Turtle getTurtle() {
		return turtle;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public BridgeListener getListener() {
		return listener;
	}

	public void ended(Runner slow, Runner fast) {
		if (passedTime > AVAILABLE_TIME)
			notifyOnBridgeEvent(new BridgeEvent(slow, fast, BridgeEventType.LOST));
		else if (passedTime == AVAILABLE_TIME && !allCrossed())
			notifyOnBridgeEvent(new BridgeEvent(slow, fast, BridgeEventType.LOST));
		else if (passedTime == AVAILABLE_TIME && allCrossed())
			notifyOnBridgeEvent(new BridgeEvent(slow, fast, BridgeEventType.WON));
		else
			notifyOnBridgeEvent(new BridgeEvent(slow, fast, BridgeEventType.CROSS));
	}

	public void notifyOnBridgeEvent(BridgeEvent e) {
		if (listener != null)
			listener.onBridgeEvent(e);
	}

	public boolean allCrossed() {
		return normal.isCrossed() && flash.isCrossed() && turtle.isCrossed() && athlete.isCrossed();
	}

	public int getAVAILABLE_TIME() {
		return AVAILABLE_TIME;
	}

	public void cross() {
		if (slow != null) {
			if (fire == slow.isCrossed()) {
				if (fast != null && fire == fast.isCrossed()) {
					slow.cross();
					passedTime += slow.getTime();
					fast.cross();
					fire = !fire;
					ended(slow, fast);
				} else if (fast == null) {
					slow.cross();
					passedTime += slow.getTime();
					fire = !fire;
					ended(slow, null);
				} else
					JOptionPane.showMessageDialog(null, "can't do this");
			} else
				JOptionPane.showMessageDialog(null, "return with someone to bring others");
		} else
			JOptionPane.showMessageDialog(null, "choose someone to cross");
		clear();
	}

	public String toString() {
		return String.format("%s\n%s\n%s\n%s", flash, athlete, normal, turtle);
	}

	public void setListener(BridgeListener listener) {
		this.listener = listener;
	}

	public int getPassedTime() {
		return passedTime;
	}
}
