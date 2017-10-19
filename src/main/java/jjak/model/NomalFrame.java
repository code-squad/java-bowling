package jjak.model;

public class NomalFrame extends Frame {

	public void setFirstScore(int firstScore) {
		state = new State(firstScore);
	}
	public void setSecondScore(int secondScore) {
		state.setSecondScore(secondScore);
	}
	public int getFirstScore() {
		return state.getFirstScore();
	}
	public int getSecondScore() {
		return state.getSeconScore();
	}
	
}
