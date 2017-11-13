package bowling.frame.state;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bowling.frame.state.nomalFrame.NomalFrameFirst;
import bowling.frame.state.nomalFrame.NomalFrameReady;
import bowling.frame.state.nomalFrame.NomalFrameSecond;
import bowling.frame.state.nomalFrame.NomalFrameSpare;
import bowling.frame.state.nomalFrame.NomalFrameStrike;

public class StateTest {
	@Test
	public void 프레임에_생성됐을때_상태() {
		State state = new NomalFrameReady();
		assertTrue(state instanceof NomalFrameReady);
	}

	@Test
	public void strike일때_상태() {
		State state = new NomalFrameReady();
		state = state.bowl(10);
		assertTrue(state instanceof NomalFrameStrike);
	}

	@Test
	public void first일때_상태() {
		State state = new NomalFrameReady();
		state = state.bowl(1);
		assertTrue(state instanceof NomalFrameFirst);
	}

	@Test
	public void spare일때_상태() {
		State state = new NomalFrameReady();
		state = state.bowl(1);
		state = state.bowl(9);
		assertTrue(state instanceof NomalFrameSpare);
	}

	@Test
	public void second일때_상태() {
		State state = new NomalFrameReady();
		state = state.bowl(1);
		state = state.bowl(2);
		assertTrue(state instanceof NomalFrameSecond);
	}
}
