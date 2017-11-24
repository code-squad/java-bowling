package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoreTest {
	Score score;
	@Before
	public void setUp() {
		score = new Score();
	}
	@Test
	public void createScoreTest() throws Exception {
		int[] pins = {10};
		String result = score.createScore(pins);
		assertEquals("X", result);
	}
}
