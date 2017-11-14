package bowling.frame.state.lastFrame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bowling.frame.state.State;
import bowling.frame.state.lastframe.LastFrameReady;

public class LastFrameFirstTest {

	@Test
	public void 현재_프레임_점수_출력() {
		State state = new LastFrameReady();
		state = state.bowl(1);
		assertEquals("1", state.getPresentScore());
	}

}
