package bowling.frame.state.lastFrame;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.state.State;

public class LastFrameSecondTest {

	@Test
	public void 현재_프레임_점수_출력() {
		State state = new LastFrameReady();
		state = state.bowl(1);
		state = state.bowl(2);
		assertEquals("1|2", state.getPresentScore());
	}

}
