package bowling.score;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void 스코어_생성() {
		Score score = new Score();
		assertEquals(score, score.inputScore(0));
	}

	@Test
	public void 처음부터_점수_여러번_더하기() {
		Score score = new Score();
		Score next = score.inputScore(10);
		next = next.inputScore(10);
		next = next.inputScore(3);
		assertEquals(23, score.totalScore(3));
	}
}
