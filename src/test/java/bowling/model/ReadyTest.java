package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
