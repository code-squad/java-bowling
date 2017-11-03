package bowling.frame.state;

import java.util.List;

public class Ready implements State {

	@Override
	public State bowl(int bowls) {
		if (bowls == 10) {
			return new Strike();
		}
		return new First(bowls);
	}

	@Override
	public String getChar() {
		return "      |";
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public int getEachFinalFrameScore() {
		throw new RuntimeException();
	}

	@Override
	public int getFirstScore() {
		return 0;
	}
}