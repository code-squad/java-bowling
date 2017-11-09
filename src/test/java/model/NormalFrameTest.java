package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFrameScoreException;

public class NormalFrameTest {

	@Test
	public void nomalFrameScoreTest() {
		NormalFrameScore normalFrameScore = new NormalFrameScore();
		normalFrameScore.firstShot(5);
		normalFrameScore.secondShot(5);
		assertEquals("5", normalFrameScore.getFirstValue());
		assertEquals("/", normalFrameScore.getSecondValue());

		NormalFrameScore nomalFrameScore2 = new NormalFrameScore();
		nomalFrameScore2.firstShot(5);
		nomalFrameScore2.secondShot(4);
		assertEquals("5", nomalFrameScore2.getFirstValue());
		assertEquals("4", nomalFrameScore2.getSecondValue());

	}

	@Test(expected = InvalidFrameScoreException.class)
	public void nomalFrameScoreExceptionTest() {
		NormalFrameScore nomalFrameScore3 = new NormalFrameScore();
		nomalFrameScore3.firstShot(10);
		nomalFrameScore3.secondShot(4);
	}
}
