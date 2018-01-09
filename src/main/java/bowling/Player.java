package bowling;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private String player;
	HashMap<Integer, Frame> frames = new HashMap<>();

	public Player(String name) {
		player = name;
	}

	public HashMap<Integer, Frame> getFrames() {
		return frames;
	}

	public void addFrame(Frame frame) {
		if (isAddPossible(frame)) {
			addFrames(frame);
		}
	}

	public boolean isAddPossible(Frame frame) {
		if (frames.get(frames.size() - 1) == frame)
			return false;
		return true;
	}

	public void addFrames(Frame currentFrame) {
		frames.put(frames.size(), currentFrame);
	}

	public void addScore(Frame currentFrame, int score) {
		currentFrame.addScore(score);
		addFrame(currentFrame);
	}

	public String getPlayerName() {
		return player;
	}

	@Override
	public String toString() {
		return (player != null ? player : "") + "";
	}

	public boolean isGameOver() {
		return frames.size() == 10 && frames.get(frames.size() - 1).isGameEnd();
	}

	public int getFramesSize() {
		return frames.size();
	}

	public boolean isGameStart() {
		return frames.size() == 0;
	}

	public void setNextFrame(Frame nextFrame) {
		if (frames.size() > 0)
			frames.get(frames.size() - 1).setNextFrame(nextFrame);
	}

	public Frame makeNextFrame() {
		if (frames.size() < 9) {
			return new NormalFrame(frames.size());
		}
		if (frames.size() == 9) {
			return new FinalFrame(frames.size());
		}
		return null;
	}

	public ArrayList<Integer> getFrameScore() {
		ArrayList<Integer> total = new ArrayList<>();
		for (Frame frame : frames.values()) {
			getScore(frame, total);
		}
		return total;
	}

	public void getScore(Frame frame, ArrayList<Integer> total) {
		if (frame.calcScore() != null)
			total.add(frame.calcScore().getFrameScore());
	}

	public String getStatusResult() {
		String result = "";
		for (Frame frame : frames.values()) {
			result += frame.getStatusResult();
		}
		return result;
	}

}
