package frame;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.EndGameException;
import bowling.FrameNo;
import bowling.Pins;
import bowling.RollForTotal;
import bowling.TotalScore;
import state.Ready;
import state.State;

public class NormalFrame implements Frame {
	private static final Logger log = LoggerFactory.getLogger(NormalFrame.class);
	private FrameNo frameNo;
	private State state;
	private Frame nextFrame;
	private Pins firstRoll;
	private Pins secondRoll;

	public NormalFrame(int frameNo) {
		this.frameNo = new FrameNo(frameNo);
		this.state = new Ready();

		if (isLastFrame()) {
			nextFrame = new NullObjectFrame();
			return;
		}
		nextFrame = new NormalFrame(frameNo + FrameNo.MIN);
	}

	@Override
	public void roll(int pinsDown) {
		if (isLastFrame() && state.isFinish()) {
			throw new EndGameException();
		}

		if (state.isFinish()) {
			createLastFrame();
			nextFrame.roll(pinsDown);
			return;
		}
		state = changeState(pinsDown);
		setPinsDown(pinsDown);
	}

	private void createLastFrame() {
		if (isLastFrame()) {
			nextFrame = FrameFactory.getLastFrame(state.needHowManyRoll());
		}
	}

	private State changeState(int pinsDown) {
		if (firstRoll != null) {
			return state.update(getFirstRollInt() + pinsDown);
		}
		return state.update(pinsDown);
	}

	private void setPinsDown(int pinsDown) {
		if (firstRoll == null) {
			firstRoll = new Pins(pinsDown);
			return;
		}
		setSecondPinsDown(pinsDown);
	}

	private void setSecondPinsDown(int pinsDown) {
		secondRoll = new Pins(pinsDown);
		secondRoll.checkPinsValid(firstRoll);
	}

	@Override
	public Frame getCurrentFrame() {
		if (state.isFinish()) {
			return nextFrame.getCurrentFrame();
		}
		return this;
	}

	@Override
	public Frame getNextFrame() {
		return nextFrame;
	}

	@Override
	public boolean isEndGame() {
		return false;
	}

	private boolean isLastFrame() {
		return getFrameNoInt() == FrameNo.MAX;
	}

	public State getState() {
		return state;
	}

	public FrameNo getFrameNo() {
		return frameNo;
	}

	public int getFrameNoInt() {
		return frameNo.getFrame();
	}

	public Pins getFirstRoll() {
		return firstRoll;
	}

	public int getFirstRollInt() {
		return getFirstRoll().getPinsDown();
	}

	public boolean isFirstRollNull() {
		return getFirstRoll() == null;
	}

	public Pins getSecondRoll() {
		return secondRoll;
	}

	public int getSecondRollInt() {
		return getSecondRoll().getPinsDown();
	}

	public boolean isSecondRollNull() {
		return getSecondRoll() == null;
	}

	
	
	@Override
	public int getFrameScore() {
		
		
		
		return getFirstRollInt() + getSecondRollInt();
	}
	
	
	
	@Override
	public Optional<TotalScore> getFrameTotal(int beforeTotal) {
		if (!isReadyCalculate()) {
			return null;
		}
		getFrameScore();
		
		
		return null;
	}
	
	@Override
	public boolean isReadyCalculate() {
		if (!state.isFinish()) {
			return false;
		}
		
		if (state.isStrike() && nextFrame.getState().isStrike()) {
			return RollForTotal.ONEROLL.getRollForTotal() < nextFrame.getNextFrame().getState().suplyHowManyRoll().getRollForTotal();
		}
		
		if (nextFrame.getState().suplyHowManyRoll().getRollForTotal() - state.needHowManyRoll().getRollForTotal() >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Frame [frameNo=" + getFrameNoInt() + "]";
	}
}
