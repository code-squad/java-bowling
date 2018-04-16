package domain;

import domain.frame.Frame;

public enum ResultType {
	STRIKE("X"),
	SPARE("%d|/"),
	MISS("%d|%d");
	
	private String pitchDisplayFormat;
	
	ResultType(String pitchDisplayFormat) {
		this.pitchDisplayFormat = pitchDisplayFormat;
	}

	/*public static ResultType resultOf(Frame frame) {
		if(frame.sumFirstSecondPitch() == 10) {

		}
		return ;
	}*/
}
