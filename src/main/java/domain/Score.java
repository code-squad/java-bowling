package domain;

public class Score {
	private int score;
	private int canScoreCount;
	
	private Score(int score, int canScoreCount) {
		this.score = score;
		this.canScoreCount = canScoreCount;
	}
	
	public static Score ofMiss(int score) {
		return new Score(score, 0);
	}
	
	public static Score ofSpare() {
		return new Score(10, 1);
	}
	
	public static Score ofStrike() {
		return new Score(10, 2);
	}
	
	public int getScore() {
		if(!canScore()) {
			throw new IllegalStateException("점수를 구할 수 없는 상태인 프레임의 점수를 합산시도하였습니다.");
		}
		
		return score;
	}
	
	public boolean canScore() {
		return canScoreCount == 0;
	}
}
