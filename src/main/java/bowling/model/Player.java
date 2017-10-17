package bowling.model;

import java.util.List;

public class Player {
	private String name;
	private Frame frame;

	public Player(String name, Frame frame) {
		this.name = name;
		this.frame = frame;
	}

	public String getName() {
		return name;
	}

	public Frame getFrame() {
		return frame;
	}

	public int setScore(String knockedPins) {
		return frame.setScore(knockedPins);
	}

	public String getScore() {
		return frame.getSumScore();
	}

	public void getKnockedPins(List<String> knockedPins, List<String> intScores) {
		frame.getKnockedPins(knockedPins, intScores);
	}

	public String getSumScore() {
		return frame.getSumScore();
	}
	
	public void calculateSumScore() {
		frame.calculateSumScore();
	}
}
