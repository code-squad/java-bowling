package bowling.model.state.last;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.state.State;

public class LastFirstTest {

	@Test
	public void 다음_상태_만들기() {
		State first = new LastFirst(3);
		State state = first.bowl(4);
		assertTrue(state instanceof LastSecond);
	}

}
