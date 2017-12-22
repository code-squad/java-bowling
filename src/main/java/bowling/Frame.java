package bowling;

import static bowling.Status.MISSORNORMAL;

import java.util.ArrayList;

public abstract class Frame {
	private ArrayList<Integer> frame = new ArrayList<>();

	public Frame(ArrayList<Integer> frame) {
		this.frame = frame;
	}

	protected void addScore(int score) {
		try {
			validateAddScore(score);
		} catch (MyException e) {
			e.getErrorMessage();
		}
		finally {
			frame.add(score);
		}
		
	}

	public void validateAddScore(int score) throws MyException {
		if(frame.size() == 1 && (frame.get(0) + score > 10))
			throw new MyException("남은 핀은 그것보다 적습니다.");
	}

	protected int getScopeOfScore() {
		int totalScore = 0;
		for (int i = 0; i < frame.size(); i++) {
			totalScore += frame.get(i);
		}
		if (totalScore == 10)
			return 1;
		if (totalScore < 10)
			return 0;
		return -1;
	}

	protected Status getStatus() {
		return Status.valueOf(getScopeOfScore(), frame.size());
	}

	protected boolean isReady() {
		return getStatus() == Status.READY;
	}

	protected boolean isMiss() {
		return (getStatus() == MISSORNORMAL) && frame.get(1) == 0;
	}

	protected boolean isNormal() {
		return (getStatus() == MISSORNORMAL && frame.get(1) != 0);
	}

	protected String getReadyResult() {
		return "\t" + frame.get(0) + " | ";
	}

	protected String getSpareResult() {
		return "/" + "\t|";
	}

	protected String getStrikeResult() {
		return "\t" + "X" + "\t| ";
	}

	protected String getMissResult() {
		return "-" + "\t|";
	}

	protected String getNormalResult() {
		return frame.get(1) + "\t|";
	}

	protected String getStatusResult() {
		if (isReady())
			return getReadyResult();

		if (isStrike()) {
			return getStrikeResult() + makeFinalStrikeResult();
		}

		if (isSpare()) {
			return getSpareResult() + makeFinalSpareResult();
		}

		if (isMiss()) {
			return getMissResult();
		}
		if (isNormal()) {
			return getNormalResult();
		}
		return "";
	}

	protected abstract boolean isSpare();

	protected abstract boolean isStrike();

	protected abstract boolean isNotEnd();

	protected abstract String makeFinalStrikeResult();

	protected abstract String makeFinalSpareResult();

}
