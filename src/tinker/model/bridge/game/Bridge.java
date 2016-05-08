package tinker.model.bridge.game;

import tinker.model.bridge.character.*;

public class Bridge {

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

	public void check() {
		if (passedTime > AVAILABLE_TIME)
			lost();
		if (passedTime == AVAILABLE_TIME && !allCrossed())
			lost();
		if (passedTime == AVAILABLE_TIME && allCrossed())
			won();
	}

	private void won() {
		System.out.println("WON!");
	}

	private void lost() {
		System.out.println("LOST!");
	}

	public boolean allCrossed() {
		return normal.isCrossed() && flash.isCrossed() && turtle.isCrossed() && athlete.isCrossed();
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

	public int getAVAILABLE_TIME() {
		return AVAILABLE_TIME;
	}

	public void cross(Runner slow, Runner fast) {
		slow.cross();
		if (fast != null)
			fast.cross();

		passedTime += slow.getTime();
		check();

		notifyOnCrossing(new CrossingEvent(slow, fast));
	}

	public void notifyOnCrossing(CrossingEvent e) {
		if (listener != null)
			listener.onCrossing(e);
	}

	public String toString() {
		return String.format("%s\n%s\n%s\n%s", flash, athlete, normal, turtle);
	}

	private void win() {
		cross(athlete, flash);
		cross(flash, null);
		cross(turtle, normal);
		cross(athlete, null);
		cross(athlete, flash);
	}

	public static void main(String[] args) {
		Bridge b = new Bridge();
		b.win();
	}

}
