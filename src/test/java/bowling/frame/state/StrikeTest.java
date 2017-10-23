package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.state.Strike;

public class StrikeTest {
	@Test (expected = UnsupportedOperationException.class)
	public void bowl() {
		new Strike().bowl(8);
	}
	
	@Test
	public void getScore() throws Exception {
		Strike strike = new Strike();
		Score score = strike.getScore();
		Spare spare = new Spare(8, 2);
		score = spare.getScore(score);
		assertEquals(20, score.getScore());
	}
}
