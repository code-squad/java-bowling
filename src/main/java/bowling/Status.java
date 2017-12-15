package bowling;

public class Status {
	private Player player;
	private Score score;
	private Frame frame;
	
	//생성자.
	public Status(Player player) {
		this.player = player;
		this.score = new Score();
		this.frame = new Frame();
	}
	//Test Code용 player 리턴.
	public Player getPlayer() {
		return player;
	}
	//Test Code용 score 리턴.
	public Score getScore() {
		return score;
	}
	//Test Code용 frame 리턴.
	public Frame getFrame() {
		return frame;
	}
}
