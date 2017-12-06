import java.util.ArrayList;
import java.util.List;

public class Player {
	
	String name;
	List<Score> scores;
	
	Player(String name, List<Score> scores) {
		this.name = name;
		this.scores = scores;
	}
	
	static List<Score> initScores() {
		List<Score> scores = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			scores.add(new Score(Score.initScore()));
		}
		return scores;
	}
	
	void makeFirstScore(int i, String firstScore) {
		this.scores.set(i, new Score(Score.getFirstScore(firstScore)));			
	}
	
	void makeSecondScore(int i, String firstScore, String secondScore) {
		this.scores.set(i, new Score(Score.getSecondScore(firstScore, secondScore)));
	}
}
