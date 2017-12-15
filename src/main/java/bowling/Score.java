package bowling;

import java.util.ArrayList;

public class Score {
	private int frameScore;
	private ArrayList<String> accumulateRecord = new ArrayList<String> ();
	
	//생성자.
	public Score() {
		frameScore = 0;
		for (int i = 0; i < 10; i++) {
			accumulateRecord.add("");
		}
	}
	//int 형의 투구 점수를 리턴.
	public int getFrameScore() {
		return frameScore;
	}
	//ArrayList<String> 형의 현재까지의 투구 결과를 리턴.
	public ArrayList<String> getAccRec() {
		return accumulateRecord;
	}
	//int형 점수를 입력받아 frameScore를 업데이트 시켜준다.
	public void updateFrameScore(int score) {
		frameScore = score;
	}
	//int형 점수를 입력받아 accumulateRecord를 업데이트 시켜준다. (첫 투구일 때,)
	public void updateFirstAccRec(int frameNum) {
		String stringScore = Integer.toString(frameScore);
		
		if (frameScore == 10) {
			accumulateRecord.set(frameNum, "X");
			return;
		}
		accumulateRecord.set(frameNum, stringScore);
	}
	//int형 점수를 입력받아 accumulateRecord를 업데이트 시켜준다. (두번째 투구일 때,)
	public void updateSecondAccRec(Frame frame) {
		String recentScore = accumulateRecord.get(frame.getFrameNum());
		if (frame.isSpare()) {
			recentScore += "/";
			accumulateRecord.set(frame.getFrameNum(), recentScore);
			return;
		}
		recentScore += "-";
		accumulateRecord.set(frame.getFrameNum(), recentScore);
		return;
	}
	//스트라이크가 아닐 때, 2구를 치기 전에 점수 사이에 " | " 를 넣어주는 메소드.
	public void readySecondShot(int frameNum) {
		String recentScore = accumulateRecord.get(frameNum);
		
		if (recentScore != "X" || recentScore != "/" || recentScore != "-") {
			recentScore += " | ";
			accumulateRecord.set(frameNum, recentScore);
		}
	}
//	//int형 점수와 framd을 입력받아 frameScore와 accumulateRecord를 업데이트 시킨다.
//	public void updateScore(int score, Frame frame) {
//		if (frame.getTryNum() == 1) {
//			frame.updatePin(score);
//			updateFrameScore(score);
//			updateFirstAccRec(frame.getFrameNum());
//			frame.addTryNum();
//			return;
//		}
//		frame.updatePin(score);
//		updateFrameScore(score);
//		readySecondShot(frame.getFrameNum());
//		updateSecondAccRec(frame);
//		frame.clearTryNum();
//	}
}
