package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 점수생성_테스트() {
		Frame first = new NormalFrame(1);
		int score1 = Score.createScore(first);
		assertEquals(20, score1);

	}

}
