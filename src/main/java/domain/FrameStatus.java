package domain;

public enum FrameStatus {
	STRIKE("X| "),
	SPARE("%s|/"),
	MISS("%s|%s"),
	PLAYING("%s| ");

	private String displayFormat;

	FrameStatus(String displayFormat) {
		this.displayFormat = displayFormat;
	}

	public String getDisplayFormat() {
		return displayFormat;
	}
}
