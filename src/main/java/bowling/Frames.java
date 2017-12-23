package bowling;

import java.util.ArrayList;

public class Frames {

	ArrayList<Frame> frames = new ArrayList<>();
	ArrayList<String> scoreBoard = new ArrayList<String> ();

	Frames() {
		for (int i = 0; i < 10; i++) {
			scoreBoard.add("");
		}
	}

	public int recentIndex() {
		return frames.size();
	}

	public String printRecentScore(int i) {
		return scoreBoard.get(i);
	}

	public void addFrame(Frame frame) {
		frames.add(frame);
	}

	public int countFrame() {
		return frames.size();
	}

	public Boolean isGameEnd(){
		return frames.size() < 10;
	}

	public void makeResultBoard(String strScore, int i) {
		scoreBoard.set(i, strScore);
	}
}