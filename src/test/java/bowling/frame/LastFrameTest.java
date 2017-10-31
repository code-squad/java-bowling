package bowling.frame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bowling.frame.state.LastReady;

public class LastFrameTest {

	@Test
	public void 마지막프레임_생성() {
		Frame frame = Frame.create(10);
		assertEquals(new LastFrame(), frame);
		// assertEquals(new LastReady(), frame);
		assertTrue(frame.state instanceof LastReady);
	}

}
