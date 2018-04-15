package domain;

public enum ResultType {
	STRIKE("X"),
	SPARE("%d|/"),
	MISS("%d|%d");
	
	private String pitchDisplayFormat;
	
	ResultType(String pitchDisplayFormat) {
		this.pitchDisplayFormat = pitchDisplayFormat;
	}
}
