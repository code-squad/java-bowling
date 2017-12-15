package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerResult {
	private String name;
	private List<String> status = new ArrayList<>();
	private List<Integer> scores =  new ArrayList<>();
	
	public PlayerResult(String name) {
		this.name = name;
	}
	
	public void addFrameResult(String str, int score) {
		status.add(str);
		scores.add(score);
	}

	public String getName() {
		return name;
	}

	public List<String> getStatus() {
		return status;
	}

	public List<Integer> getScores() {
		return scores;
	}
}