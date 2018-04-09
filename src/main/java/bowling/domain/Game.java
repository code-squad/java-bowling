package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Frame> frames;
	String name;

	public Game(List<Frame> frames, String name) {
		this.name = name;
		this.frames = frames;
	}

	public static Game of(String name) {
		List<Frame> frames = new ArrayList<>(10);
		return new Game(frames, name);
	}

	public String getDownPin(int frameNum) {
		if (getFrame(frameNum) == null) {
			return "   ";
		}
		return getFrame(frameNum).getDownPin();
	}

	public Frame getFrame(int frameNum) {
		for (int i = 0; i < frames.size(); i++) {
			if (getFrameNum(i) == frameNum) {
				return frames.get(i);
			}
		}
		return null;
	}

	public void setFrame(int frameNum, Frame frame) {
		for (int i = 0; i < frames.size(); i++) {
			if (getFrameNum(i) == frameNum) {
				frames.set(i, frame);
				return;
			}
		}
	}

	public int getFrameNum(int i) {
		return frames.get(i).getNum();
	}

	public void addFrame(Frame frame) {
		this.frames.add(frame);
	}

	public Boolean addFrame(int inputThrowScore, int frameNum, int throwTime) {
		if (frameNum == 10) {
			return addLastFrame(inputThrowScore, frameNum, throwTime);
		}
		return addNormalFrame(inputThrowScore, frameNum, throwTime);

	}

	public Boolean addNormalFrame(int inputThrowScore, int frameNum, int throwTime) {
		if (throwTime == 2) {
			setFrame(frameNum, NormalFrame.of(frameNum, getFrame(frameNum), inputThrowScore));
			return false;
		}
		addFrame(NormalFrame.of(frameNum, inputThrowScore, 0));
		if (inputThrowScore == 10) {
			return false;
		}
		return true;
	}

	public Boolean addLastFrame(int inputThrowScore, int frameNum, int throwTime) {
		if (throwTime == 2) {
			return LastFrameSecondThrow(inputThrowScore, frameNum);
		}
		if (throwTime == 3) {
			setFrame(frameNum, LastFrame.of(frameNum, getFrame(frameNum), inputThrowScore));
			return false;
		}
		addFrame(LastFrame.of(frameNum, inputThrowScore, 0, 0));
		return true;
	}

	public Boolean LastFrameSecondThrow(int inputThrowScore, int frameNum) {
		setFrame(frameNum, LastFrame.of(frameNum, getFrame(frameNum), inputThrowScore));
		if (getFrame(frameNum).isSecondThrowSpare(inputThrowScore)) {
			return true;
		}
		return false;
	}

}
