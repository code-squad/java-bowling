package bowling;

public class Frame {

	Score score;

	public void bowl(int first, int second) {
		score = new MissScore(first, second);
	}

	public String scoreToString() {
//		if (score.currentScore() < 10) {
//			return String.format("%s | %s", (score.first == 0) ? "-" : score.first, (score.second == 0) ? "-" : score.second);
//		}
//
//		if (score.first == 10) {
//			return String.format("%s", "X");
//		}
//
//		if (score.second == 10) {
//			return String.format("%s | %s", "-", "/");
//		}
//
//		return String.format("%d | %s", score.first, "/");
		return super.toString();
	}

}
