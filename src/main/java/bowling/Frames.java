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

	private int getNullIndex(ArrayList<Integer> result) {
		return result.indexOf(null);
	}
	
	private boolean isNullStringNeeded(ArrayList<Integer> frameResult, Frame frame) {
		return frameResult.size() < 3 && (frame.getStatus().isSpare() || frame.getStatus().isStrike());
	}
	
	public ArrayList<Integer> makeTotalScoreBoardform() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> totalResult = new ArrayList<Integer> ();
		
		for (Frame frame : frames) {
			ArrayList<Integer> frameResult = new ArrayList<Integer> ();
			frameResult.addAll(frame.frame);
			while (isNullStringNeeded(frameResult, frame)) {
				frameResult.add(null);
			}
			result.add(frameResult);
		}
		
		result = fillTotalScoreBoard(result);
		
		for (int i = 0; i < result.size(); i++) {
			totalResult.add(calculateTotalScore(result.get(i)));
		}
		
		totalResult = makeTotalResultBoard(totalResult);
		
		return totalResult;
//		System.out.println("");
//		System.out.println(result);
//		System.out.println(totalResult);
	}
	
	private ArrayList<ArrayList<Integer>> fillTotalScoreBoard(ArrayList<ArrayList<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			if (getNullIndex(result.get(i)) == 1 && i < result.size() - 2) {
				if (getNullIndex(result.get(i+1)) == 1) {
					result.get(i).set(1, result.get(i+1).get(0));
					result.get(i).set(2, result.get(i+2).get(0));
				}
				result.get(i).set(1, result.get(i+1).get(0));
				result.get(i).set(2, result.get(i+1).get(1));
			}
			if (getNullIndex(result.get(i)) == 2 && i < result.size() - 1) {
				result.get(i).set(2, result.get(i+1).get(0));
			}
		}
		return result;
	}
	
	private int calculateTotalScore(ArrayList<Integer> result) {
		int count = 0;
		
		for (int i = 0; i < result.size(); i++) {
			if (!result.contains(null)) {
				count += result.get(i);
			}
		}
		return count;
	}
	
	private ArrayList<Integer> makeTotalResultBoard(ArrayList<Integer> totalResult) {
		int count = 0;
		for (int i = 0; i < totalResult.size(); i++) {
			count += totalResult.get(i);
			totalResult.set(i, count);
		}
		return totalResult;
	}
}