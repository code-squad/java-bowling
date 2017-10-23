package bowling.model;

public class Player {
	private String name;
	private Frame frame;
	private Frame nowFrame;
	public Player(String name) {
		this.name = name;
		this.frame = new Frame(1);
		this.nowFrame = frame;
	}
	public String getName() {
		return name;
	}
	
	public void bowl(int knockedPins) {
		nowFrame = nowFrame.bowl(knockedPins);
		
	}
	

}
