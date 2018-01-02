package bowling;

import java.util.ArrayList;
import java.util.List;

public abstract class Score {
	private Integer chance;
	protected Integer frameScore;

	public Score(int chance) {
		this.chance = chance;
	}

	public void addStatus(Status status) {
		if (isStatusNotFix())
			chance = status.getScoreSize();
	}

	public boolean isScoreCalc() {
		System.out.println("frameScore : " + frameScore);
		return frameScore != null;
	}

	public boolean isStatusNotFix() {
		return chance == null;
	}

	protected boolean isNotEnd() {
		return chance != 0;
	}

	protected void useChance() {
		chance -= 1;
	}
	
	protected boolean isFrameFill(ArrayList<Integer> currentFrame){
		return currentFrame.size() == 2;
	}
	
	public int getFrameScore(){
		return getScore(null, null);
	}
	
	public abstract Integer getScore(Frame preFrame, Frame pastFrame);


	public boolean isBiggerSize(List<Integer> collectScore) {
		return collectScore.size() >= chance;
	}

}
