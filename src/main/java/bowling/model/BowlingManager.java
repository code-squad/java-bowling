package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class BowlingManager {
	private List<Player> players;
	
	public BowlingManager(){
		players = new ArrayList<>();
	}

	public void initPlayer(String name) {
		players.add(new Player(name, FrameFactory.initFrames()));
	}
}