package bowling;

import static bowling.Status.MISSORNORMAL;

import java.util.ArrayList;

public class FinalFrame extends Frame {

	ArrayList<Integer> extraFrame = new ArrayList<>();

	public FinalFrame() {
		super();
	}

	@Override
	public boolean isNotEnd() {
		return getStatus() != Status.MISSORNORMAL && getStatus() != null;
	}

	@Override
	protected Status getStatus() {
		if (frame.size() != 1 && isPinClear()) {
			
		}
		return Status.valueOf(isPinClear(), frame.size());
	}

	@Override
	public boolean isPinClear() {
		int totalScore = 0;
		for (int i = 0; i < frame.size(); i++) {
			totalScore += frame.get(i);
		}
		return totalScore % 10 == 0 && totalScore != 0;
	}

	@Override
	public String changeFormat() {
		String strScore = "" + frame.get(0);
		if (isPinClear()) {
			strScore = checkStrikeOrSpare(getStatus());
		}
		if (getStatus() == MISSORNORMAL) {
			strScore = checkMissOrNormal(frame.get(1));
		}

		return isFirstOrNot(strScore);
	}
	
	@Override
	protected String checkStrikeOrSpare(Status status) {
		if (frame.size() != 1 && frame.get(0) + frame.get(frame.size()-1) > 10) {
			return "X";
		}
		if (frame.size() == 1) {
			return "X";
		}
		return "/";
	}
}