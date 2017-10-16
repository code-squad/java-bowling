package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 입력받은_값으로_생성해보자() {
		Score score = new Score();
		score.setScore("10");
		assertEquals("X", score.getKnockedPins());
		assertEquals(10, score.getScore());

		score.setScore("2|5");
		assertEquals("2|5", score.getKnockedPins());
		assertEquals(7, score.getScore());

		score.setScore("3|7");
		assertEquals("3|/", score.getKnockedPins());
		assertEquals(10, score.getScore());
	}
}
