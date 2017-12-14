package bowling;

import java.util.ArrayList;

public class Score {
	private int frameScore;
	private ArrayList<String> accumulateRecord = new ArrayList<String> ();
	
	//생성자.
	public Score() {
		frameScore = 0;
	}
	//int 형의 투구 점수를 리턴.
	public int getFrameScore() {
		return frameScore;
	}
	//ArrayList<String> 형의 현재까지의 투구 결과를 리턴.
	public ArrayList<String> getAccRec() {
		return accumulateRecord;
	}
	//int형 점수와 int형 시도숫자를 입력받아 frameScore와 accumulateRecord를 업데이트 시킨다.
	public void updateScore(int score, int tryNum) {
		if (tryNum == 1) {
			updateFrameScore(score);
			updateFirstAccRec(score);
			return;
		}
		updateFrameScore(score);
		updateSecondAccRec(score);
	}
	//int형 점수를 입력받아 frameScore를 업데이트 시켜준다.
	public void updateFrameScore(int score) {
		frameScore = score;
	}
	//int형 점수를 입력받아 accumulateRecord를 업데이트 시켜준다. (첫 투구)
	public void updateFirstAccRec(int score) {
		String stringScore = Integer.toString(score);
		
		if (score == 10) {
			accumulateRecord.add("X");
			return;
		}
		accumulateRecord.add(stringScore);
	}
	//int형 점수를 입력받아 accumulateRecord를 업데이트 시켜준다. (두번째 투구)
		public void updateSecondAccRec(int score) {
			String stringScore = Integer.toString(score);
			
			int last = accumulateRecord.size() - 1;
			String lastScore = accumulateRecord.get(last);
			
			if (score == 10) {
				lastScore += "X";
				accumulateRecord.set(last, lastScore);
				return;
			}
			lastScore += stringScore;
			accumulateRecord.set(last, lastScore);
		}
	//점수판을 채우기 위해 체크하는 메소드.
	public void checkAccRec() {
		int last = accumulateRecord.size() - 1;
		String lastScore = accumulateRecord.get(last);
		
		if (lastScore != "X" || lastScore != "/" || lastScore != "-") {
			lastScore += " | ";
			accumulateRecord.set(last, lastScore);
		}
	}
}
