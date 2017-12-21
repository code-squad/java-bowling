


import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private List<Frame> frames = new ArrayList<>();
	private Frame currentFrame = new Frame(0);
	private List<Score> scores = new ArrayList<>();
	private Score currentScore = new Score();
	private List<Integer> totalScores = new ArrayList<>();
	private int sum = 0;
	private int j = 0;
	private int k = 0;

	Player(String name) {
		this.name = name;
		frames.add(currentFrame);
	}
	
	List<Integer> getTotalScores() {
		return this.totalScores;
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
	
	void play (int pinsPerTry) {
		currentFrame.bowl(pinsPerTry);
		frames.set(currentFrame.getFrameNum(), currentFrame);
		makeScores(pinsPerTry);
		if (currentFrame.isEnded()) {
			currentFrame = currentFrame.makeNewFrame();
			frames.add(currentFrame);
		}
	}

	private void makeScores(int pinsPerTry) {
		currentScore.bowl(pinsPerTry);
		if (currentScore.isEnded()) {
			addCurrentScoreAndMakeEmpty();
			for (int i = j; i < frames.size(); i++) {
				currentScore.addPinsInScoreSet(frames.get(i).pinsPerFrame);
			}
			if (currentScore.isEnded()) {
				addCurrentScoreAndMakeEmpty();
			}
		}
		makeTotalScores();
	}

	private void makeTotalScores() {
		for (int i = k; i < scores.size(); i++) {
			sum += scores.get(k).calculateScoreSet();
			totalScores.add(sum);
			k++;
		}
	}

	private void addCurrentScoreAndMakeEmpty() {
		j++;
		scores.add(currentScore);
		currentScore = new Score();
	}
	
	boolean isFinished () {
		return currentFrame.isEnded();
	}
}
