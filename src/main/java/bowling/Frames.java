package bowling;

import java.util.ArrayList;

public class Frames {
	ArrayList<Frame> totalFrames = new ArrayList<>();

	Frames() {

	}

	public void addFrame(Frame frame) {
		totalFrames.add(frame);
	}

	public void updateFrames(Frame frame) {
		totalFrames.set(countFrame() - 1, frame);
	}

	public Frame getFrame(int index) {
		return totalFrames.get(index);
	}

	public int countFrame() {
		return totalFrames.size();
	}

	public Boolean isGameEnd(){
		return totalFrames.size() < 10;
	}

	public Boolean isNotStart() {
		return countFrame() == 0;
	}

	public Frame getLastFrame() {
		return getFrame(countFrame() - 1);
	}

	public ArrayList<String> makeResultBoard() {
		ArrayList<String> resultList = new ArrayList<>();
		for(Frame frame : totalFrames) {
			resultList.add(frame.changeFormat());
		}

		for (int i = resultList.size(); i < 10; i++) {
			resultList.add("");
		}
		return resultList;
	}

	public static ArrayList<String> initializeResult() {
		ArrayList<String> resultBoard = new ArrayList<String> ();
		for (int i = 0; i < 10; i++) {
			resultBoard.add("");
		}
		return resultBoard;
	}

	public ArrayList<String> makePrintResult() {
		ArrayList<String> result = new ArrayList<String> ();
		int count = 0;
		for(Frame frame : totalFrames) {
			count += frame.makeFrameScore();
			result.add(count + "");
		}
		return result;
	}
}