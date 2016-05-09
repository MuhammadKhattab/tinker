package tinker.model.bridge.game;

import java.util.EventObject;

import tinker.model.bridge.character.Runner;

@SuppressWarnings("serial")
public class BridgeEvent extends EventObject {

	private Runner fast;
	private BridgeEventType type;

	public BridgeEvent(Runner slow, Runner fast, BridgeEventType type) {
		super(slow);
		this.fast = fast;
		this.type = type;
	}

	public Runner getFast() {
		return fast;
	}

	public BridgeEventType getType() {
		return type;
	}

}
