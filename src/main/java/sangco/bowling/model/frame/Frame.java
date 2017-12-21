package sangco.bowling.model.frame;

import java.util.HashMap;

public interface Frame {
	public int getScoreFirstRoll();

	public int getScoreSecondRoll();

	public int getGameTotalScore();

	public int setGameTotalScore(int totalScore, int scoreFirstRoll);
}
