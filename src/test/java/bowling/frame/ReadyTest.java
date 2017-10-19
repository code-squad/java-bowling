package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.FirstBowl;
import bowling.frame.Ready;
import bowling.frame.State;
import bowling.frame.Strike;

public class ReadyTest {
	@Test
	public void bowl_strike() throws Exception {
		Ready ready = new Ready();
		State state = ready.bowl(10);
		assertTrue(state instanceof Strike);
	}
	
	@Test
	public void bowl_first() throws Exception {
		Ready ready = new Ready();
		State state = ready.bowl(9);
		assertTrue(state instanceof FirstBowl);
	}
}
