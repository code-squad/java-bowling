package bowling.model;

public class Player {
	String name;
	Frame frame;

	public Player(String name, Frame frame) {
		this.name = name;
		this.frame = frame;
	}

	public String getName() {
		return name;
	}

	public Frame getFrame() {
		return frame;
	}
}
