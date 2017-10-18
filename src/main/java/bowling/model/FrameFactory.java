package bowling.model;

public class FrameFactory {

	public static Frame initFrames() {
		Frame frame = new Frame();
		for (int i = 0; i < 8; i++) {
			frame.addFrame(new Frame());
		}
		frame.addFrame(new LastFrame());
		return frame;
	}
}
