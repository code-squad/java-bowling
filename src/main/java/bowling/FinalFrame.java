package bowling;

import java.util.ArrayList;

public class FinalFrame extends Frame {
	private ArrayList<String> finalScore = new ArrayList<String> ();
	
	public FinalFrame() {
		super();
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
		finalScore.set(0, convertStrike(strScore));
		
		if (isPinClear()) {
			finalScore.set(getLastIndex(), isFirstOrNot(checkStrikeOrSpare()));
			return makeString(finalScore);
		}
		if (getStatus().isMissOrNormal() || getStatus().isExtraShot()) {
			strScore = checkMissOrNormal(getLastData());
			finalScore.set(getLastIndex(), isFirstOrNot(strScore));
			
		}
		return makeString(finalScore);
	}
	
	@Override
	protected String isFirstOrNot(String convertedScore) {
		if (pins.size() > 1) {
			return "|" + convertedScore;
		}
		return convertedScore;
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
	
	private String makeString(ArrayList<String> result) {
		String finalResult = "";
		for (int i = 0; i < result.size(); i++) {
			finalResult += result.get(i);
		}
		return finalResult;
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