package bowling.model;

public class Score {
	private int intScore;
	private String strScore;
	private String sumScore;

	public Score() {
		strScore = null;
	}

	public void settingScore(String strScore) {
		this.strScore = makeStrScore(strScore);
	}

	private String makeStrScore(String str) {
		if (str.equals("10")) {
			intScore = 10;
			return "X";
		}
		return calStrScore(str);
	}

	private String calStrScore(String str) {
		String[] strArr = str.split("|");
		intScore = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
		if (intScore == 10) {
			return strArr[0] + "|/";
		}
		return str;
	}S

	public boolean isNotSetting() {
		return strScore == null;
	}

	public int getIntScore() {
		return intScore;
	}

	public String getStrScore() {
		return strScore;
	}
}
