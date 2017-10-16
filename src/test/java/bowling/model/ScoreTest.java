package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 입력받은_값으로_생성해보자() {
		Score score = new Score();
		score.settingScore("10");
		assertEquals("X", score.getStrScore());
		assertEquals(10, score.getIntScore());

		score.settingScore("2|5");
		assertEquals("2|5", score.getStrScore());
		assertEquals(7, score.getIntScore());

		score.settingScore("3|7");
		assertEquals("3|/", score.getStrScore());
		assertEquals(10, score.getIntScore());
	}
}
