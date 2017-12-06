import java.util.ArrayList;
import java.util.List;

public class Score {
	
	List<String> score;
	
	Score (List<String> score) {
		this.score = score;
	}
	
	static List<String> initScore() {
		List<String> initialScore = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			initialScore.add(" ");
		}
		initialScore.add("|");
		return initialScore;
	}
	
	static List<String> getFirstScore(String stringScore) {
		List<String> score = initScore();
		if (stringScore.equals("10")) {
			score.set(2, "X");
			return score;
		}
		score.set(2, stringScore);
		return score;
	}
	
	static List<String> getSecondScore(String stringFirstScore, String stringSecondScore) {
		List<String> score = initScore();
		score.set(2, stringFirstScore);
		score.set(3, "|");
		score.set(4, stringSecondScore);
		return score;
	}
	

}
