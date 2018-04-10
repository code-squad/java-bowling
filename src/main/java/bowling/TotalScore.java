package bowling;

public class TotalScore {
	
	private int score;
	public static final int MIN = 0;
	public static final int MAX = 300;

	public TotalScore(int score) {
		if (MIN > score || MAX < score) {
			throw new IllegalArgumentException("볼링 점수는 최소 0점 부터 300점 까지 입니다.");
		}
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
}
