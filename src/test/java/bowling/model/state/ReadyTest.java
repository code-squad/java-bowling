package bowling.model.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.state.FirstBowl;
import bowling.model.state.Ready;
import bowling.model.state.Strike;

public class ReadyTest {

	@Test
	public void 스트라이크를_입력_받았을_때() {
		State ready = new Ready();
		State state = ready.bowl(10);
		assertTrue(state instanceof Strike);
	}

	@Test
	public void 일반적인_점수를_입력_받았을때() {
		State ready = new Ready();
		State state = ready.bowl(4);
		assertTrue(state instanceof FirstBowl);
	}

	@Test
	public void 스트라이크를_만들어_보자() {
		State ready = new Ready();
		State state = ready.bowl(10);
		assertTrue(state instanceof Strike);
	}
}
