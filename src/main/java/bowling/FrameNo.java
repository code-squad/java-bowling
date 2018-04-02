package bowling;

public class FrameNo {
	private int frame;
	public static final int MIN = 1;
	public static final int MAX = 10;

	public FrameNo(int frame) {
		if (MIN > frame || MAX < frame) {
			throw new IllegalArgumentException("한 게임에는 10개의 프레임이 존재합니다.");
		}
		this.frame = frame;
	}
	
	public boolean isLastFrame() {
		return frame == 10;
	}

	public int getFrame() {
		return frame;
	}
}
