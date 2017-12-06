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
			stringScore = "X";
		}
		if (stringScore.equals("0")) {
			stringScore = "-";
		}
		score.set(2, stringScore);
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
