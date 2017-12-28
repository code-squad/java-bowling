import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Frame> frames = new ArrayList<>();
	private Frame currentFrame = new Frame(0);

	Player(String name) {
		this.name = name;
		frames.add(currentFrame);
	}

	List<Integer> getTotalScores() {
		int sum = 0;
		List<Integer> totalScores = new ArrayList<>();
		for (Score score : getScores()) {
			sum += score.getScore();
			totalScores.add(sum);
		}
		return totalScores;
	}

	List<Score> getScores() {
		List<Score> scores = new ArrayList<>();
		for (Frame frame : frames) {
			if (frame.getScore() != null) {
				scores.add(frame.getScore());
			}
		}
		return scores;
	}

	int getCurrentFrameNo() {
		return this.currentFrame.getFrameNum();
	}

	Frame getCurrentFrame() {
		return this.currentFrame;
	}

	String getName() {
		return this.name;
	}

	List<Frame> getFrames() {
		return this.frames;
	}

	void play(int pinsPerTry) {
		Frame frame = currentFrame.bowl(pinsPerTry);
		if (frame.isEnded()) {
			if (frame.getFrameNum() == 9) {
				return;
			}
			currentFrame = frame.makeNewFrame();
			frames.add(currentFrame);
		}
	}

	boolean isFinished() {
		return currentFrame.isEnded();
	}
}
