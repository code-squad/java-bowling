package bowling.frame.state;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StateTest {
	@Test
	public void 프레임에_생성됐을때_상태() {
		State state = new Ready();
		assertTrue(state instanceof Ready);
	}

	@Test
	public void strike일때_상태() {
		State state = new Ready();
		state = state.bowl(10);
		assertTrue(state instanceof Strike);
	}

	@Test
	public void first일때_상태() {
		State state = new Ready();
		state = state.bowl(1);
		assertTrue(state instanceof First);
	}

	@Test
	public void spare일때_상태() {
		State state = new Ready();
		state = state.bowl(1);
		state = state.bowl(9);
		assertTrue(state instanceof Spare);
	}

	@Test
	public void second일때_상태() {
		State state = new Ready();
		state = state.bowl(1);
		state = state.bowl(2);
		assertTrue(state instanceof Second);
	}
}
