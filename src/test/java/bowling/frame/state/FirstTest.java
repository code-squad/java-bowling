package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstTest {

	@Test
	public void 현재_프레임_점수_출력() {
		State state = new Ready();
		state = state.bowl(1);
		assertEquals("1", state.getPresentScore());
	}

}
