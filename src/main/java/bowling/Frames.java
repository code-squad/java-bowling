package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frames {
	ArrayList<Frame> frames = new ArrayList<>();

	Frames() {
	}

	public ArrayList<Frame> getFrames() {
		return frames;
	}

	public void addFrame(Frame frame) {
		frames.add(frame);
	}

	public int countFrame() {
		return frames.size() + 1;
	}

	public Boolean isGameEnd() {
		return frames.size() < 10;
	}

	public List<Integer> collectScores(Frame frame) {
		List<Integer> collectScore = new ArrayList<>();
		for (Frame pastFrame : frames) {
			pastFrame.addFrameScore(collectScore);
		}
		frame.addFrameScore(collectScore);

		return reverseScores(collectScore);
	}

	private List<Integer> reverseScores(List<Integer> collectScore) {
		List<Integer> reverseScore = new ArrayList<>();
		for (int i = collectScore.size() - 1; i >= 0; i--) {
			reverseScore.add(collectScore.get(i));
		}
		System.out.println("reverseScore : " + reverseScore);
		return reverseScore;
	}

	public void checkScore(Frame currentFrame) {
		for (int i = 0; i < frames.size(); i++) {
			if (!frames.get(i).isScoreCalc() ) {
				if (currentFrame.getStatus() == Status.MISSORNORMAL)
					currentFrame.calcMissOrNormalScore();
				if(frames.get(i).getStatus() == Status.SPARE)
					currentFrame.calcSpareScore(frames.get(i));
				if(frames.get(i).getStatus() == Status.STRIKE){
					currentFrame.calcPastStrikeScore(frames.get(i));
					if(i >= 1 && frames.get(i-1).getStatus() == Status.STRIKE)
						currentFrame.calcPrePastStrikeScore(frames.get(i-1));
				}
			}
		}

	}

	public List<Integer> getTotalScore(Frame currentFrame) {
		List<Integer> totalScore = new ArrayList<>();

		for (Frame frame : frames) {
			totalScore.add(frame.getScore());
		}
		if(currentFrame.isScoreCalc())
			totalScore.add(currentFrame.getScore());

		return totalScore;
	}

}
