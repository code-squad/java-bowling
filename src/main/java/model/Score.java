package model;

public class Score {
	private int score;
	private int nextAddNo; // 추가로 합산하는 횟수, miss = 0, spare = 1, strike = 2.
	
	public Score(int score, int nextAddNo) {
		this.score = score;
		this.nextAddNo = nextAddNo;
	}
	
	public void add(int falledPin) {
		this.score += falledPin;
		nextAddNo--;
	}
	
	public boolean isEnd() {
		return nextAddNo == 0;
	}
}
