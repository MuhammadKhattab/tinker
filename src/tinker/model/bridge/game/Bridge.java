package tinker.model.bridge.game;

import javax.swing.JOptionPane;

import tinker.model.bridge.character.*;

public class Bridge {

	private int AVAILABLE_TIME = 17;
	private int passedTime;
	private boolean fire;

	private Flash flash;
	private Sleepy sleepy;
	private Turtle turtle;
	private Rabbit rabbit;

	private Runner slow;
	private Runner fast;

	private BridgeListener listener;

	public Bridge() {
		sleepy = new Sleepy();
		flash = new Flash();
		turtle = new Turtle();
		rabbit = new Rabbit();
	}

	public void setSlow(Runner slow) {
		this.slow = slow;
	}

	public void setFast(Runner fast) {
		this.fast = fast;
	}

	public void clear() {
		slow = null;
		fast = null;
	}

	public void addRunner(Runner runner) {
		if (slow == null) {
			slow = runner;
		}
		else if (slow.isCrossed() == runner.isCrossed() && slow.getClass() != runner.getClass()) {
			if (slow.getTime() > runner.getTime())
				fast = runner;
			else {
				Runner tmp = slow;
				slow = runner;
				fast = tmp;
			}
			
		} else {
			clear();
		}
	}

	public boolean isFire() {
		return fire;
	}

	public Flash getFlash() {
		return flash;
	}

	public Turtle getTurtle() {
		return turtle;
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
		return sleepy.isCrossed() && flash.isCrossed() && turtle.isCrossed() && rabbit.isCrossed();
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

	public void setListener(BridgeListener listener) {
		this.listener = listener;
	}

	public int getPassedTime() {
		return passedTime;
	}

	public Sleepy getSleepy() {
		return sleepy;
	}

	public Rabbit getRabbit() {
		return rabbit;
	}
	
	public Runner getSlow() {
		return slow;
	}
	
	public Runner getFast() {
		return fast;
	}

}
