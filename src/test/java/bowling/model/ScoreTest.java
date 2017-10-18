package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 입력받은_값으로_생성해보자() {
		Score score1 = new Score();
		score1.setScore("10");
		assertEquals("X ", score1.getKnockedPins());
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
	
	@Test
	public void 누적_점수_구하기() {
		Score score = new Score();
		score.setScore("10");
		score.calculateSumScore("first");
		assertEquals("10", score.getSumScore());
		
		score = new Score();
		score.setScore("2");
		score.setScore("3");
		score.calculateSumScore("10");
		assertEquals("15", score.getSumScore());
	}
	
	@Test
	public void 프레임에_첫번째_투구_점수_구하기() {
		Score score = new Score();
		score.setScore("3");
		score.setScore("7");
		assertEquals(3, score.firstRoundScore());
	}
}
