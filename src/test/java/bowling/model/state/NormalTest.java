package bowling.model.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class NormalTest {

	@Test(expected = IllegalArgumentException.class)
	public void 스페어상태로_만들어져야_할_값으로_Normal_상태를_만들어보자() {
		new Normal(4, 6);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void 새로운_투구_결과를_추가해_보자() {
		new Normal(3, 5).bowl(3);
	}
	
	@Test
	public void getScoreTest() {
		State state = new Normal(4,4);
		assertEquals("4|4", state.getKnockedPins());
	}
}
