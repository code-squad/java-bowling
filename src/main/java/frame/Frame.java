package frame;

import java.util.Optional;

import bowling.Pins;
import bowling.TotalScore;
import state.State;

public interface Frame {
	public void roll(int pinsDown);
	
	public Frame getCurrentFrame();

	public Frame getNextFrame();

	public boolean isEndGame();
	
	public Pins getFirstRoll();

	public Pins getSecondRoll();
	
	public Optional<TotalScore> getFrameTotal(int beforeTotal);
	
	public boolean isReadyCalculate();
	
	public int getFrameScore();
	
	public State getState();
}
