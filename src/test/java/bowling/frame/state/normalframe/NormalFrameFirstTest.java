package bowling.frame.state.normalframe;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameReady;

public class NormalFrameFirstTest {

	@Test
	public void 현재_프레임_점수_출력() {
		State state = new NormalFrameReady();
		state = state.bowl(1);
		assertEquals("1", state.getPresentScore());
	}

}
