package bowling;

public class FinalFrame extends Frame {
	private LastScore lastScore;

	public FinalFrame() {
		super();
	}

	@Override
	public boolean isNotEnd() {
		if (frame.isEmpty())
			return true;
		if (getStatus() != null)
			lastScore = new LastScore(getStatus().getLastChance());
		lastScore.useChance();
		return lastScore.isFinal();
	}

	@Override
	public String changeFormat() {
		String result = "";
		if (isReady()) {
			result = "\t" + frame.get(0) + " | ";
			return result;
		}
		if (isStrike()) {
			result = "\t" + "X" + " | " + frame.get(1) + " | " + frame.get(2);
			return result;
		}
		if (isSpare()) {
			result += "/" + "|" + frame.get(2);
			return result;
		}
		if (isMiss()) {
			result += "-" + "\t|";
			return result;
		}
		if (isNormal()) {
			result += frame.get(1) + "\t|";
			return result;
		}
		return result;
	}

	public boolean isSpare() {
		return (frame.size() == 3) && (frame.get(0) + frame.get(1) == 10);
	}

	public boolean isStrike() {
		return (frame.size() == 3) && frame.get(0) == 10;

	}

}