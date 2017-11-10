package bowling.score;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 초기화() {
		Score score = Score.inputScore(9);
		assertEquals(score, Score.inputScore(9));
	}

}
