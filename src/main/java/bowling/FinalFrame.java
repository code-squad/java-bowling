package bowling;

import static bowling.Status.*;


public class FinalFrame extends Frame {
	private LastScore lastScore;

	public FinalFrame() {
		super();
	}

	private Boolean isFinal() {
		if(lastScore.useChance() != 0)
			return true;
		return false;
	}

	@Override
	public boolean isNotEnd() {
		if (frame.isEmpty())
			return true;
		if (getStatus() != null)
			lastScore = new LastScore(getStatus().lastChance);
		return isFinal();
	}

	@Override
	public String changeFormat() {
		String result = "";
		if (frame.size() == 3 && frame.get(0) == 10) {
			result = "\t" + "X" + "|" + frame.get(1) + "|" + frame.get(2);
			return result;
		}
		if (frame.size() == 3 && frame.get(0) + frame.get(1) == 10) {
			result = "\t" + frame.get(0) + " | /" + "|" + +frame.get(2);
			return result;
		}
		if (getStatus() == MISSORNORMAL && frame.get(1) == 0)
			result = "\t" + frame.get(0) + " | -" + "\t|";
		if (getStatus() == MISSORNORMAL && frame.get(1) != 0)
			result = "\t" + frame.get(0) + " | " + frame.get(1) + "\t|";
		return result;

	}

}