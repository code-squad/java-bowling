package bowling.frame;

public class FrameResult {
	private String frame;
	private int score;

	public FrameResult(int calc) {
		this.score = score;
	}

	public String getFrame() {
		return frame;
	}

	public int getScore() {
		return score;
	}

	public static FrameResult add(int calc) {
		return new FrameResult(calc);
	}

}
