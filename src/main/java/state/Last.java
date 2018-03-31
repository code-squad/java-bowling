package state;

import bowling.Pins;

public class Last extends State {
	private State state;
	private boolean gameEnd = false;
	private Pins firstBonusRoll;
	private Pins secondBonusRoll;

	public Last() {
		state = new Ready();
	}

	@Override
	public State update(int pinsDown) {
		if (state.isFinish() && !state.canRollBonusBowl()) {
			return state;
		}
		
		if (state.isFinish() && state.canRollBonusBowl()) {
			rollBonusBowl(state, pinsDown);
			return this;
		}
		state = state.update(pinsDown);
		return this;
	}

	private void rollBonusBowl(State state, int pinsDown) {
		if (firstBonusRoll == null && state instanceof Strike) {
			firstBonusRoll = new Pins(pinsDown);
			return;
		}
		
		if (firstBonusRoll != null && state instanceof Strike) {
			secondBonusRoll = new Pins(pinsDown);
			gameEnd = true;
		}
		firstBonusRoll = new Pins(pinsDown);
		gameEnd = true;
	}
	
	
	@Override
	public Pins getSecondRoll() {
		return null;
	}

	@Override
	public boolean isFinish() {
		return gameEnd;
	}

	@Override
	public boolean canRollBonusBowl() {
		return false;
	}

	@Override
	public boolean isStrike() {
		return false;
	}
}
