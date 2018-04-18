package domain;

public enum PlayStatus {
	STRIKE("X"),
	SPARE("/"),
	MISS("-"),
	GUTTER("-"),
	OPEN("%d"),
	NONE("%d");

	private String displayFormat;

	PlayStatus(String displayFormat) {
		this.displayFormat = displayFormat;
	}

	public String getDisplayFormat() {
		return displayFormat;
	}
}
