package sangco.bowling.model.frame;

import java.util.ArrayList;
import java.util.HashMap;

public interface Frame {

	public int getGameTotalScore();

	public int setGameTotalScore(HashMap<Integer, Frame> scoreBoard, int totalScore);

	public int getScoreFirstRoll();

	public int getScoreSecondRoll();

	public int getScoreFrame();

	public boolean getTotalSetOrNot();
}
