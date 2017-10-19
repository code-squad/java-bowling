package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.FirstBowl;
import bowling.frame.Miss;
import bowling.frame.Spare;
import bowling.frame.State;

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
