package sangco.bowling.model;

import java.util.ArrayList;

import sangco.bowling.model.state.BowlingState;

public class Board {
	ArrayList<Frame> scoreBoard = new ArrayList<>();
	private int totalScore = 0;
	private boolean nextFrame = false;
	// nextFrame이 false이면 Frame 객체를 생성하고
	// true이면 setSecondRoll을 해준다.

	public void createFrame(int inputScore) {
		if (timeToCreateLastFrame() && variableNextFrameIsFalse()) {
			nextFrame = createLastFrame(inputScore);
			return;
		}
		if (variableNextFrameIsTrue()) {
			nextFrame = setSecondRoll(inputScore);
			setTotalScore();
			return;
		}
		nextFrame = setNomalFrame(inputScore);
	}

	private boolean setNomalFrame(int inputScore) {
		createNomalFrame(inputScore);
		saveNextFrame();
		return (inputScore == 10) ? false : true;
		// 처음 던진 공이 스트라이크면 false를 리턴해서 setSecondRoll을 안타게
	}

	private void createNomalFrame(int inputScore) {
		scoreBoard.add(new NomalFrame(inputScore));
	}

	private boolean createLastFrame(int inputScore) {
		scoreBoard.add(new LastFrame(inputScore));
		saveNextFrame();
		return true;
	}

	private boolean setSecondRoll(int inputScore) {
		saveNextRoll(inputScore);
		return isLastFrame() ? true : false;
		// LastFrame의 경우 true를 반환해서
		// 다음 공도 setSecondRoll 메소드를 타게 만든다.
	}

	private void setTotalScore() {
		for (Frame frame : scoreBoard) {
			if (frame.getTotalSetOrNot() == false) {
				totalScore = frame.setGameTotalScore(totalScore);
			}
		}
	}
	
	private void saveNextRoll(int inputScore) {
		getThisFrame().setNextRoll(inputScore);
	}

	private void saveNextFrame() {
		if (scoreBoard.size() >= 2) {
			getLastFrame().setNextFrame(getThisFrame());
			setTotalScore();
		}
	}

	private Frame getThisFrame() {
		return scoreBoard.get(getThisFrameIndex());
	}

	private int getThisFrameIndex() {
		return scoreBoard.size() - 1;
	}

	private NomalFrame getLastFrame() {
		return (NomalFrame) scoreBoard.get(scoreBoard.size() - 2);
	}
	
	private boolean timeToCreateLastFrame() {
		return scoreBoard.size() == 9;
	}
	
	private boolean isLastFrame() {
		return scoreBoard.size() == 10;
	}

	private boolean variableNextFrameIsTrue() {
		return nextFrame == true;
	}

	private boolean variableNextFrameIsFalse() {
		return nextFrame == false;
	}
	
	Frame getEachFrame(int index) {
		return scoreBoard.get(index);
	}

	BowlingState getEachFrameState(int index) {
		return ((NomalFrame) scoreBoard.get(index)).getState();
	}

	Frame getEachFrameNextFrame(int index) {
		return ((NomalFrame) scoreBoard.get(index)).getNextFrame();
	}
	
	int getTotalScore() {
		return scoreBoard.get(getThisFrameIndex()).getTotalScore();
	}
}
