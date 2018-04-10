package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Frame> frames;

	public Game(List<Frame> frames) {
		this.frames = frames;
	}

	public static Game of() {
		List<Frame> frames = new ArrayList<>();
		return new Game(frames);
	}

	public void addNormalFrame(int frameNum, Score score) {
		frames.add(NormalFrame.of(frameNum, score));
	}
	public void addLastFrame(int frameNum, Score score) {
		frames.add(LastFrame.of(frameNum, score));
	}

	public int size() {
		return frames.size();
	}
	
	public String getDownPin(int i) {
		return frames.get(i).getDownPin();
	}
	
	

}
