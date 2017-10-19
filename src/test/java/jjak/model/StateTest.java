package jjak.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateTest {
	State state;

	@Test
	public void test() {
		state = new State(6);
		assertEquals(6, state.getFirstScore());
		state.setSecondScore(2);
		assertEquals(2, state.getSeconScore());
	}

}
