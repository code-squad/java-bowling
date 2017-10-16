package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 입력받은_값으로_생성해보자() {
		Score score1 = new Score();
		score1.setScore("10");
		assertEquals("X", score1.getKnockedPins());
		assertEquals(10, score1.getScore());

		Score score2 = new Score();
		score2.setScore("2");
		score2.setScore("5");
		assertEquals("25", score2.getKnockedPins());
		assertEquals(7, score2.getScore());

		Score score3 = new Score();
		score3.setScore("3");
		score3.setScore("7");
		assertEquals("3/", score3.getKnockedPins());
		assertEquals(10, score3.getScore());
	}
}
