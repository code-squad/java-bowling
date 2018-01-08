package bowling;

import java.util.ArrayList;

public class FinalFrame extends Frame {
	private ArrayList<String> finalScore = new ArrayList<String> ();

	public FinalFrame(int frameNo) {
		super(frameNo);
		for (int i = 0; i < 3; i++) {
			finalScore.add("");
		}
	}

	protected boolean isNotEnd() {
		return doExtraShot() || isFirstShotStrike();
	}

	protected String changeFormat() {
		String strScore = "";
		checkFirstShot(strScore);

		if (isPinClear()) {
			updateFinalFrame(checkStrikeOrSpare());
			return makeFinalToString();
		}

		if (getStatus().isMissOrNormal() || getStatus().isExtraShot()) {
			updateFinalFrame(checkMissOrNormal(getLastData()));
		}
		return makeFinalToString();
	}

	protected int checkSecondIsRight() {
		if (getStatus().isStrike() || getStatus().isSpare()) {
			return 0;
		}
		if (pins.size() == 0) {
			return 0;
		}
		return getLastData();
	}

	protected String isFirstOrNot(String convertedScore) {
		if (pins.size() > 1) {
			return "|" + convertedScore;
		}
		return convertedScore;
	}

	private String checkFirstShot(String strScore) {
		if (pins.size() == 1) {
			strScore = "" + pins.get(0);
			finalScore.set(0, convertStrike(strScore));
		}
		return strScore;
	}

	private void updateFinalFrame(String input) {
		finalScore.set(getLastIndex(), isFirstOrNot(input));
	}

	private boolean isFirstShotStrike() {
		return pins.get(0) == 10 && pins.size() < 3;
	}

	private boolean doExtraShot() {
		return (!getStatus().isMissOrNormal()) && (!getStatus().isExtraClearShot()) && (!getStatus().isExtraNormalShot());
	}

	private String convertStrike(String score) {
		if (score.equals("10")) {
			return "X";
		}
		return score;
	}

	private String makeFinalToString() {
		String finalResult = "";
		for (int i = 0; i < finalScore.size(); i++) {
			finalResult += finalScore.get(i);
		}
		return finalResult;
	}

	private String checkStrikeOrSpare() {
		if (getLastData() == 0) {
			return "-";
		}
		if (getLastData() != 10) {
			return "/";
		}
		return "X";
	}

	private int getLastIndex() {
		return pins.size() - 1;
	}
}