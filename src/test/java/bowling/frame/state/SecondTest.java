package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecondTest {

	@Test
	public void 현재_프레임_점수_출력() {
		State state = new Ready();
		state = state.bowl(1);
		state = state.bowl(2);
		assertEquals("1|2", state.getPresentScore());
	}

}
