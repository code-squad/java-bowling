package model;

import java.util.ArrayList;
import java.util.List;

import Exception.HasNotFinishedException;
import Exception.HasNotValueYetException;
import Exception.InvalidFrameNumberException;

public class Player {
	private String name;
	private List<Frame> frames = new ArrayList<>();
	private static final int FRAME_START_NO = 1;
	public Frame currentFrame = new NormalFrame(FRAME_START_NO);
	
	public Player(String name) {
		this.name = name;
	}
	
	private void addFirstFrame() {
		frames.add(currentFrame);
	}

	public void bowl(Pin pin) throws InvalidFrameNumberException {
		if (frames.size() == 0) {
			addFirstFrame();
		}
		Frame frame = currentFrame.addAfterDecide(pin);
		if (currentFrame.isNewFrame(frame)) {// 현재 프레임이 끝났으면,
			frames.add(frame);
			currentFrame = frame;
		}
	}
	public List<String> getTotal() {
		List<String> totalScores = new ArrayList<>();
		List<Score> scores = getScores();
		int total = 0;
		for (int i = 0; i < scores.size(); i++) {
			if (scores.isEmpty() || scores.get(i) == null) {
				totalScores.add("  ");
				return totalScores;
			}
			total += scores.get(i).getScore();
			totalScores.add(total + "");
		}
		return totalScores;
	}

	public List<Score> getScores() {
		List<Score> scores = new ArrayList<>();
		for (int i = 0; i < currentFrame.getFrameNum(); i++) {
			Score score = getScore(frames.get(i));
			if(score != null) {
				scores.add(score);
			}
		}
		return scores;
	}
	private Score getScore(Frame frame) {// 해당 프레임의 score 구하는 메소드.
		Score score;
		try {
			if(frame.isTenthFrame()) {
				score = frame.calculateTenthScore(frame.decide());
				return score;
			}
			Frame nextFrame = frame.getNextFrame();
			score = nextFrame.calculateScore(frame.decide());
		} catch (HasNotFinishedException | HasNotValueYetException e) {
			score = null;
		}
		return score;
	}

	public List<Status> makeStatus() {
		List<Status> allStatus = new ArrayList<>();
		for (Frame frame : this.frames) {
			if (!frame.getPins().isEmpty()) {
				allStatus.add(frame.decideStatus());
			}
		}
		return allStatus;
	}

	public List<Frame> getFrames() {
		return frames;
	}
}
