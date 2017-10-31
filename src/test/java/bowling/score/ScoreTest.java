package bowling.score;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bowling.frame.state.Bonuce;
import bowling.frame.state.Second;

public class ScoreTest {

	@Test
	public void 스코어계산기() {
		Score score = Score.calculate(new Second(2, 3));
		assertEquals(new Score(new Second(2, 3)), score);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 스코어계산기_예외_case1() {
		Score score = Score.calculate(new Bonuce(2, 3));
		assertEquals(new Score(new Bonuce(2, 3)), score);
	}

}
