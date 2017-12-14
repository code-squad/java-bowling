package bowling;

public class Player {
	private String name;
	private int totalScore;
	
	public Player(String name) {
		this.name = name;
		this.totalScore = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
}
