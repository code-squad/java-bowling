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

	@Override
	protected boolean isNotEnd() {
		return doExtraShot() || isFirstShotStrike();
	}

	@Override
	protected String changeFormat() {
		String strScore = "" + pins.get(0);
		if (isPinClear()) {
			strScore = checkStrikeOrSpare(getStatus());
			return strScore + "|" + convertStrike(pins.get(2) + "");
		}
		if (getStatus().isMissOrNormal()) {
			strScore = checkMissOrNormal(getLastData());
		}

		return isFirstOrNot(strScore);

	}
	@Override
	protected int checkSecondIsRight() {
		if (getStatus().isStrike() || getStatus().isSpare()) {
			return 0;
		}
		if (pins.size() == 0) {
			return 0;
		}
		return getLastData();
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
	
//	private String makeString(ArrayList<String> result) {
//		String finalResult = "";
//		for (int i = 0; i < result.size(); i++) {
//			finalResult += result.get(i);
//		}
//		return finalResult;
//	}
//
//	private String checkStrikeOrSpare() {
//		if (getLastData() == 0) {
//			return "-";
//		}
//		if (getLastData() != 10) {
//			return "/";
//		}
//		return "X";
//	}
//
//	private int getLastIndex() {
//		return pins.size() - 1;
//	}
}