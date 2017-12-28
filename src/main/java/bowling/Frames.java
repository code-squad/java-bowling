package bowling;

import java.util.ArrayList;

public class Frames {
	ArrayList<Frame> frames = new ArrayList<>();

	Frames() {
		
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
	
	public ArrayList<String> makeResultBoard() {
		ArrayList<String> resultList = initializeResult();
		int count = 0;
		for (Frame frame : frames) {
			resultList.set(count, frame.changeFormat());
			count++;
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
	
	private int getLastIndex() {
		return frames.size() - 1;
	}
	
	public ArrayList<Integer> makeTotalScoreBoard() {
		ArrayList<ArrayList<Integer>> totalScoreBoard = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> frameScore = new ArrayList<Integer> ();
		int totalScore = 0;
		
		for (Frame frame : frames) {
			totalScoreBoard.add(frame.frame);
		}
		//------
		
		
		
		//------
		return totalScoreBoard.get(getLastIndex());
	}
}