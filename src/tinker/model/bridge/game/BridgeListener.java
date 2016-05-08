package tinker.model.bridge.game;

import java.util.EventListener;

public interface BridgeListener extends EventListener{

	void onCrossing(CrossingEvent e);
	
}
