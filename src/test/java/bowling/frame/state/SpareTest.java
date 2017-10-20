package bowling.frame.state;

import org.junit.Test;

import bowling.frame.state.Spare;

public class SpareTest {
	@Test(expected = IllegalArgumentException.class)
	public void create_illegal() throws Exception {
		new Spare(7, 2);
	}
	

	@Test(expected = UnsupportedOperationException.class)
	public void bowl() {
		new Spare(8, 2).bowl(8);
	}
}
