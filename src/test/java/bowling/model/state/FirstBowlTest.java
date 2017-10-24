package bowling.model.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.state.Normal;
import bowling.model.state.Ready;
import bowling.model.state.Spare;
import bowling.model.state.State;

public class FirstBowlTest {

	@Test
	public void 스페어_만들기() {
		State state = new FirstBowl(4);
		state = state.bowl(6);
		assertTrue(state instanceof Spare);
	}

	@Test
	public void 일반_만들기() {
		Ready ready = new Ready();
		State firstBowl = ready.bowl(4);
		firstBowl = firstBowl.bowl(3);
		assertTrue(firstBowl instanceof Normal);
	}
	
	@Test
	public void getScoreTest() {
		State firstBowl = new FirstBowl(5);
		assertEquals("5", firstBowl.getKnockedPins());
	}
}
