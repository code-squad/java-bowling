package bowling.frame.state;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bowling.frame.state.normalframe.NormalFrameFirst;
import bowling.frame.state.normalframe.NormalFrameReady;
import bowling.frame.state.normalframe.NormalFrameSecond;
import bowling.frame.state.normalframe.NormalFrameSpare;
import bowling.frame.state.normalframe.NormalFrameStrike;

public class StateTest {
	@Test
	public void 프레임에_생성됐을때_상태() {
		State state = new NormalFrameReady();
		assertTrue(state instanceof NormalFrameReady);
	}

	@Test
	public void strike일때_상태() {
		State state = new NormalFrameReady();
		state = state.bowl(10);
		assertTrue(state instanceof NormalFrameStrike);
	}

	@Test
	public void first일때_상태() {
		State state = new NormalFrameReady();
		state = state.bowl(1);
		assertTrue(state instanceof NormalFrameFirst);
	}

	@Test
	public void spare일때_상태() {
		State state = new NormalFrameReady();
		state = state.bowl(1);
		state = state.bowl(9);
		assertTrue(state instanceof NormalFrameSpare);
	}

	@Test
	public void second일때_상태() {
		State state = new NormalFrameReady();
		state = state.bowl(1);
		state = state.bowl(2);
		assertTrue(state instanceof NormalFrameSecond);
	}
}
