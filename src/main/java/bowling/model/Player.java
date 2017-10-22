package bowling.model;

public class Player {
	private String name;
	private Frame frame;
	private Frame nextFrame;
	public Player(String name) {
		this.name = name;
		this.frame = new Frame(1);
	}
	public String getName() {
		return name;
	}

}
