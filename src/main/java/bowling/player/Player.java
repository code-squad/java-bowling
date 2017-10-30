package bowling.player;

import bowling.frame.Frame;
import bowling.state.State;

public class Player {

	private Frame frame;
	private String name;
	private State state;

	public Player(String name) {
		this.name = name;
		frame = new Frame(1);
		state = frame.getState();
	}

	public Frame bowl(int score) {
		frame = frame.bowl(score);
		state = frame.getState();
		return frame;
	}

	public String getName() {
		return name;
	}

	public Frame getFrame() {
		return frame;
	}

	public boolean isEnd() {
		return state.isEnd();
	}
}
