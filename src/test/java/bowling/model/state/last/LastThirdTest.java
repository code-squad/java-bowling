package bowling.model.state.last;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.state.State;

public class LastThirdTest {

	@Test(expected = UnsupportedOperationException.class)
	public void 세번째_상태에_투구_점수를_추가해보자() {
		State third = new LastThird(4, 7, 2);
		third.bowl(3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_값으로_세번째_상태를_만들어_보자() {
		State third = new LastThird(4, 3, 2);
		third.bowl(3);
	}
	
	@Test
	public void getScoreTest() {
		State state = new LastThird(3,7,3);
		assertEquals("3|/|3", state.getKnockedPins());
	}

}
