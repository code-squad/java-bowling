package domain;

import domain.frame.Frame;

public enum ResultType {
	STRIKE("X", ""),
	SPARE("%s", "|/"),
	MISS("%s", "|%s"),
	EMPTY("%d| ", "");

	private String firstPitchFormat;
	private String secondPitchFormat;

	ResultType(String firstPitchFormat, String secondPitchFormat) {
		this.firstPitchFormat = firstPitchFormat;
		this.secondPitchFormat = secondPitchFormat;
	}

	public static ResultType resultOf(Frame frame) {
		if(!frame.isComplete()) {
			return EMPTY;
		}

		if(!frame.hasSecondPitch()) {
			return STRIKE;
		}

		if(frame.isPinRemained()) {
			return MISS;
		}

		return SPARE;
	}

	public String getDisplayFormat() {
		return firstPitchFormat + secondPitchFormat;
	}
}
