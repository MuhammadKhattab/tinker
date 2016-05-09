package tinker.model.bridge.game;

import tinker.model.bridge.character.*;

public class Bridge {

	// TODO
	// handle invalid moves:
	// - choose same runner
	// - one must always go back

	private int AVAILABLE_TIME = 17;
	private int passedTime;

	private Flash flash;
	private Normal normal;
	private Turtle turtle;
	private Athlete athlete;

	private BridgeListener listener;

	public Bridge() {
		normal = new Normal();
		flash = new Flash();
		turtle = new Turtle();
		athlete = new Athlete();
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

	public void cross(Runner slow, Runner fast) {
		if (slow != null) {
			slow.cross();
			passedTime += slow.getTime();
			if (fast != null)
				fast.cross();
			ended(slow, fast);
		}
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
