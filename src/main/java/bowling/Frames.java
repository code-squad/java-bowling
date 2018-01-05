package bowling;

import java.util.ArrayList;

public class Frames {
	ArrayList<Frame> totalFrames = new ArrayList<>();

	Frames() {

	}

	public void addFrame(Frame frame) {
		totalFrames.add(frame);
	}
	
	public int countFrame() {
		return totalFrames.size();
	}

	public Boolean isGameEnd(){
		return totalFrames.size() < 10;
	}

	public ArrayList<String> makeResultBoard() {
		ArrayList<String> resultList = initializeResult();
		int count = 0;
		for (Frame frame : totalFrames) {
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
	
	public ArrayList<Integer> makeTotalScoreBoardform2() {
		ArrayList<Score> result = new ArrayList<Score> ();
		ArrayList<Integer> totalResult = new ArrayList<Integer> ();
		
		for (Frame frame : totalFrames) {
			Score frameScore = new Score(frame);
			result.add(frameScore);
			totalResult.add(frameScore.getFrameScore());
		}
		
		//result = fillTotalScoreBoard2(result);
		
		totalResult = makeTotalResultBoard(totalResult);
		
		return totalResult;
	}
	
//	private ArrayList<ArrayList<Integer>> fillTotalScoreBoard(ArrayList<ArrayList<Integer>> result) {
//		for (int i = 0; i < result.size(); i++) {
//			if (getNullIndex(result.get(i)) == 1 && i < result.size() - 2) {
//				if (getNullIndex(result.get(i+1)) == 1) {
//					result.get(i).set(1, result.get(i+1).get(0));
//					result.get(i).set(2, result.get(i+2).get(0));
//				}
//				result.get(i).set(1, result.get(i+1).get(0));
//				result.get(i).set(2, result.get(i+1).get(1));
//			}
//			if (getNullIndex(result.get(i)) == 2 && i < result.size() - 1) {
//				result.get(i).set(2, result.get(i+1).get(0));
//			}
//		}
//		return result;
//	}
	
	private ArrayList<Integer> makeTotalResultBoard(ArrayList<Integer> totalResult) {
		int count = 0;
		for (int i = 0; i < totalResult.size(); i++) {
			if (totalResult.get(i) == null) {
				continue;
			}
			count += totalResult.get(i);
			totalResult.set(i, count);
		}
		return totalResult;
	}
}