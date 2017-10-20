package bowling.frame.state;

import org.junit.Test;

import bowling.frame.state.Strike;

public class StrikeTest {
	@Test (expected = UnsupportedOperationException.class)
	public void bowl() {
		new Strike().bowl(8);
	}
}
