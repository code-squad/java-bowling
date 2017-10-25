package bowling.frame.state;

import bowling.frame.CannotCalculateException;

public class TenReady extends Running {
	@Override
	public State bowl(int countOfPin) {
		return new TenFirst(countOfPin);
	}
	
	public Score cacluateAdditionalScore(Score score) {
		throw new CannotCalculateException();
	}
	
	@Override
	public String getDesc() {
		return "";
	}
}
