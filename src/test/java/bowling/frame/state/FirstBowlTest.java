package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.state.FirstBowl;
import bowling.frame.state.Miss;
import bowling.frame.state.Spare;
import bowling.frame.state.State;

public class FirstBowlTest {

	@Test
	public void bowl_spare() {
		FirstBowl firstBowl = new FirstBowl(9);
		State state = firstBowl.bowl(1);
		assertTrue(state instanceof Spare);
	}
	
	@Test
	public void bowl_miss() throws Exception {
		FirstBowl firstBowl = new FirstBowl(9);
		State state = firstBowl.bowl(0);
		assertTrue(state instanceof Miss);
	}

}
