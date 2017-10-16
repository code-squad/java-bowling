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

	public void setScore(String knockedPins) {
		frame.setScore(knockedPins);
	}

	public int getScore() {
		return frame.getSumScore();
	}

	public void getKnockedPins(List<String> knockedPins, List<Integer> intScores) {
		frame.getKnockedPins(knockedPins, intScores);
	}
}
