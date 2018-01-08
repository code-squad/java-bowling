package bowling;

public class NormalFrame extends Frame {
	NormalFrame(int frameNo) {
		super(frameNo);
	}

	protected boolean isNotEnd() {
		return getStatus().isReady() || getStatus().isFirstshot();
	}
	protected String changeFormat() {
		String strScore = "" + pins.get(0);
		if (isPinClear()) {
			strScore = checkStrikeOrSpare(getStatus());
			return strScore;
		}
		if (getStatus().isMissOrNormal()) {
			strScore = checkMissOrNormal(getLastData());
		}

		return isFirstOrNot(strScore);
	}

	protected String isFirstOrNot(String convertedScore) {
		if (pins.size() > 1) {
			return pins.get(0) + "|" + convertedScore;
		}
		return convertedScore;
	}

	protected int checkSecondIsRight() {
		if (getStatus().isFirstshot()) {
			return getLastData();
		}
		return 0;
	}
}