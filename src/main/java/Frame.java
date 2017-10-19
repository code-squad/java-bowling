
public abstract class Frame {
	int firstTryScore;
	int secondTryScore;
	int count;
	boolean strike = false;
	boolean spare = false;

	abstract public void secondScoreInsert(int score);
}

// 끝난 프레임만 계산
