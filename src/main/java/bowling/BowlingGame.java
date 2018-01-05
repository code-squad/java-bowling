package bowling;

import java.util.ArrayList;

public class BowlingGame {
	private static Frame takeInput(Frames frames, Frame frame) {
		while (frame.isNotEnd()) {
			frame.addScore(InputView.inputScore(frame.getFrameNo(), frame));
			frames.updateFrames(frame);
			ResultView.printScore("hi", frames.makeResultBoard());
		}
		return frame;
	}
	
	private static Frame checkFrame(Frame frame) {
		if (!frame.isNotEnd()) {
			return frame.addScore(0);
		}
		return frame;
	}

	public static void playOneFrame(Frames frames, String playerName) {
		ArrayList<Integer> totalResult = new ArrayList<Integer> ();
		
		if (frames.countFrame() == 0) {
			Frame frame = new Frame(1);
			frames.addFrame(frame);
			frame = takeInput(frames, frame);
			return;
		}
		
		Frame frame = frames.getFrame(frames.countFrame() - 1);
		frame = checkFrame(frame);
		frames.addFrame(frame);
		frame = takeInput(frames, frame);
		return;
	}

	//------------------MAIN START-------------------
	public static void main(String[] args) {
		String playerName = InputView.inputName();
		Frames frames = new Frames();

		while (frames.isGameEnd()) {
			playOneFrame(frames, playerName);
			
			//--
			System.out.println("");
			for (int i = 0; i < frames.countFrame(); i++) {
				System.out.print(frames.totalFrames.get(i).pins + " ");
				System.out.print(frames.totalFrames.get(i).makeFrameScore() + " ");
			}
			//--
			
		}
	}
}