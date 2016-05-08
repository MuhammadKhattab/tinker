package tinker.model.bridge.game;

import java.util.EventObject;

import tinker.model.bridge.character.Runner;

@SuppressWarnings("serial")
public class CrossingEvent extends EventObject{

	private Runner fast;
	
	public CrossingEvent(Runner runner) {
		super(runner);
	}
	
	public CrossingEvent(Runner slow, Runner fast) {
		super(slow);
		this.fast = fast;
	}

}
