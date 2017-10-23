package bowling.model.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpareTest {

	@Test(expected = IllegalArgumentException.class)
	public void 잘못_된_값으로_스페어를_생성해보자() {
		new Spare(3, 4);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void 스페어에_새로_값을_추가해보자() {
		new Spare(4, 6).bowl(4);
	}
	
	@Test
	public void getScoreTest() {
		State state = new Spare(3,7);
		assertEquals("3|/", state.getScore());
		
	}
}
