package bowling.frame;

import org.junit.Test;

import bowling.frame.Strike;

public class StrikeTest {
	@Test (expected = UnsupportedOperationException.class)
	public void bowl() {
		new Strike().bowl(8);
	}
}
