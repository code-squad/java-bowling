package bowling.model;

public class Player {
	private String name;
	private Frame first;
	private Frame now;
	private Frame before;
	public Player(String name) {
		this.name = name;
		this.first = new NormalFrame(1);
		this.now = first;
	}
	public String getName() {
		return name;
	}
	
	public void bowl(int knockedPins) {
		before = now;
		now = now.bowl(knockedPins);
	}
	
	public int getNowNo() {
		return now.getNo();
	}
	
	public String getKnockedPins() {
		return before.getKnockedPins();
	}
	public int getScore() {
		return first.getScore();
	}

}
