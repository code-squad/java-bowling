package model;

public class FrameResult {

	private String status;
	private String score;

	public FrameResult(String status, String score) {
		this.status = status;
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public String getScore() {
		return score;
	}
}
