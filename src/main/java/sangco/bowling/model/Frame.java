package sangco.bowling.model;

public interface Frame {
	public int getFirstRoll();
	public int getFrameTotalScore();
	public int getGameTotalScore();
	public void setGameTotalScore(int totalScore);
}
