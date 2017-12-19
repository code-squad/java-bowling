package sangco.bowling.model;

import java.util.ArrayList;
import java.util.HashMap;

import sangco.bowling.view.InputView;

public class Board {
	private HashMap<Integer, Frame> scoreBoard = new HashMap<>();
	private static ArrayList<Integer> totalScoreList;
	private boolean strike = false;
	private boolean spare = false;
	private boolean doubleStrike = false;

	public Board() {
		totalScoreList = new ArrayList<>();
		totalScoreList.add(0, 0);
	}

	public void createFrame(int frame, int scoreFirstRoll) {
		scoreBoard.put(frame, (frame == 10) ? new LastFrame(scoreFirstRoll) : new NormalFrame(scoreFirstRoll));
		setTotalScoreCase(frame);
	}

	private void setTotalScoreCase(int frame) {
		int thisFrameScore = 0;
		int lastTotalScore = totalScoreList.get(0);

		thisFrameScore = (totalScoreList.get(1) == 10) ? getScoreCase1(frame) : getScoreCase2(frame);
		setSpareData();
	}

	private void setSpareData() {
		int frameScore = totalScoreList.get(1) + totalScoreList.get(2);
		if(frameScore == 10) {
			spare = true;
		}
	}
	
	
	
	
	private int getScoreCase1(int frame) {
		return (doubleStrike == true) ? getScoreCase3(frame) : (spare == true) ? getScoreCase4(frame) : getScoreCase9();
	}

	
	
	
	
	private int getScoreCase2(int frame) {
		return (doubleStrike == true) ? getScoreCase5(frame)
				: (strike == true) ? getScoreCase6(frame)
						: (spare == true) ? getScoreCase7(frame) : getScoreCase8(frame);
	}

	
	
	
	
	
	private int getScoreCase3(int frame) {
		scoreBoard.get(frame - 2).setGameTotalScore(30);
		return 30;
	}

	private int getScoreCase4(int frame) {
		scoreBoard.get(frame - 1).setGameTotalScore(20);
		strike = true;
		return 20;
	}

	private int getScoreCase5(int frame) {
		int frameScore = 20 + totalScoreList.get(1);
		scoreBoard.get(frame - 2).setGameTotalScore(frameScore);
		doubleStrike = false;
		return frameScore;
	}

	private int getScoreCase6(int frame) {
		int frameScore = 10 + totalScoreList.get(1) + totalScoreList.get(2);
		scoreBoard.get(frame - 1).setGameTotalScore(frameScore);
		strike = false;
		return frameScore;
	}

	private int getScoreCase7(int frame) {
		int frameScore = 10 + totalScoreList.get(1);
		scoreBoard.get(frame - 1).setGameTotalScore(frameScore);
		spare = false;
		return frameScore;
	}

	private int getScoreCase8(int frame) {
		int frameScore = totalScoreList.get(1) + totalScoreList.get(2);
		if(frameScore != 10) {
			scoreBoard.get(frame).setGameTotalScore(frameScore);
			return frameScore;
		}
		return 0;
	}

	private int getScoreCase9() {
		if (strike == true) {
			doubleStrike = true;
		}
		strike = true;
		return 0;
	}

	public static ArrayList<Integer> getTotalScoreList() {
		return totalScoreList;
	}

	public static void setTotalScoreList(int inputScore) {
		totalScoreList.add(inputScore);
	}
}