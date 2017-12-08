import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Score> scores;
	private List<Frame> frames;
	
	Player(String name, List<Score> scores) {
		this.name = name;
		this.scores = scores;
	}
	
	String getName() {
		return this.name;
	}
	
	List<Score> getScores() {
		return this.scores;
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
	
	static void play(View view, Player player, int i) {
		String firstScore = Input.getScore(i);
		player.makeFirstScore(i, firstScore);
		View.view(view, player);				
		if (!firstScore.equals("10")) {
			String secondScore = Input.getScore(i);
			player.makeSecondScore(i, firstScore, secondScore);
			View.view(view, player);
		}
	}
}
