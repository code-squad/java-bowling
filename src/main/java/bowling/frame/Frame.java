package bowling.frame;

import bowling.frame.state.State;

public abstract class Frame {

	State state;
	private int firstScore;
	private int secondScore;

	public State bowl(int score) {
		state = state.bowl(score);
		firstScore = state.getFristScore();
		secondScore = state.getSecondScore();
		System.out.println(firstScore);
		System.out.println(secondScore);
		return state;
	}

	public State getState() {
		return state;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public int getEndScore() {
		return firstScore + secondScore;
	}
}
