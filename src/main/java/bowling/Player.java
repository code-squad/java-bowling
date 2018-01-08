package bowling;

public class Player {
	protected String name;
	protected Frames frames;
	
	public Player(String name, Frames frames) {
		this.name = name;
		this.frames = frames;
	}
	
	public boolean isGameEnd() {
		return frames.isGameEnd();
	}
	
	public boolean isNotStart() {
		return frames.isNotStart();
	}
}
