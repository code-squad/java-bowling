package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFinFalledException;

public class NormalFrameTest {

	@Test
	public void nomalFrameScoreTest() {
		NormalFrame normalFrame = new NormalFrame();
		normalFrame.firstShot(5);
		normalFrame.secondShot(5);
		assertEquals("5", normalFrame.getFirstValue());
		assertEquals("/", normalFrame.getSecondValue());

		NormalFrame nomalFrame2 = new NormalFrame();
		nomalFrame2.firstShot(5);
		nomalFrame2.secondShot(4);
		assertEquals("5", nomalFrame2.getFirstValue());
		assertEquals("4", nomalFrame2.getSecondValue());

	}

	@Test(expected = InvalidFinFalledException.class)
	public void nomalFrameScoreExceptionTest() {
		NormalFrame nomalFrame3 = new NormalFrame();
		nomalFrame3.firstShot(10);
		nomalFrame3.secondShot(4);
	}
}
