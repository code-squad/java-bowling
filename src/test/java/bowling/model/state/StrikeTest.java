package bowling.model.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrikeTest {

	@Test(expected = UnsupportedOperationException.class)
	public void 스트라이크에_새로운_투구_점수를_추가해_보자() {
		State state = new Strike();
		state.bowl(3);
	}
	
	@Test
	public void getScoreTest() {
		State state = new Strike();
		assertEquals("X", state.getKnockedPins());
	}
}
