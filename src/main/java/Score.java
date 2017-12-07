import java.util.ArrayList;
import java.util.List;

public class Score {
	
	List<String> score;
	
	Score (List<String> score) {
		this.score = score;
	}
	
	List<String> getScore() {
		return this.score;
	}
	
	static List<String> initScore() {
		List<String> initialScore = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			initialScore.add(" ");
		}
		initialScore.add("|");
		return initialScore;
	}
	
	static List<String> getFirstScore(String firstScore) {
		List<String> score = initScore();
		if (firstScore.equals("10")) {
			firstScore = "X";
		}
		if (firstScore.equals("0")) {
			firstScore = "-";
		}
		score.set(2, firstScore);
		return score;
	}
	
	static List<String> getSecondScore(String firstScore, String secondScore) {
		List<String> score = initScore();
		if (Integer.parseInt(firstScore) + Integer.parseInt(secondScore) == 10) {
			secondScore = "/";
		}
		if (firstScore.equals("0")) {
			firstScore = "-";
		}
		if (secondScore.equals("0")) {
			secondScore = "-";
		}
		score.set(2, firstScore);
		score.set(3, "|");
		score.set(4, secondScore);
		return score;
	}
	

}
