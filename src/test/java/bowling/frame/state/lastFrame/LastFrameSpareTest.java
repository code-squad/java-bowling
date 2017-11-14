package bowling.frame.state.lastFrame;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.state.State;
import bowling.frame.state.lastframe.LastFrameReady;

public class LastFrameSpareTest {

	@Test
	public void 현재_프레임_점수_출력() {
		State state = new LastFrameReady();
		state = state.bowl(2);
		state = state.bowl(8);
		assertEquals("2|/", state.getPresentScore());
	}

}
