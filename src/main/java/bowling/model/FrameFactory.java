package bowling.model;

public class FrameFactory {

	public static Frame initFrames() {
		Frame frame = new Frame();
		for (int i = 0; i < 9; i++) {
			frame.addFrame(new Frame());
		}
		return frame;
	}
}
