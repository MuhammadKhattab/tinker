package tinker.model.bridge.character;

public abstract class Runner {

	private int time;
	private boolean crossed;
	
	public Runner(int time) {
		this.time = time;
		crossed = false;
	}
	
	public boolean isCrossed() {
		return crossed;
	}
	
	public void cross() {
		crossed = !crossed;
	}
	
	public void setCrossed(boolean crossed) {
		this.crossed = crossed;
	}
	
	public int getTime() {
		return time;
	}
	
	public String toString() {
		return String.format("takes: %d, safe: %b", time,crossed);
	}
	
}
