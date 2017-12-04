package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 점수생성_테스트() {
		Pin pin1 = new Pin(10);
		Pin pin2 = new Pin(1);
		Pin pin3 = new Pin(9);
		int score1 = Score.createFinalScore(pin1);
		int score2 = Score.createFinalScore(pin2);
		int score3 = Score.createFinalScore(pin3);
		assertEquals(20, score3);

	}

}
