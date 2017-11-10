package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFinFalledException;
import exception.InvalidFrameScoreException;

public class FrameTest {

	@Test
	public void nomalFrameScoreTest() {
		Frame frame = new Frame();
		frame.shot(5);
		frame.shot(5);
		assertEquals("5|/", frame.getCurrentScoreBoard());

		Frame frame2 = new Frame();
		frame2.shot(5);
		frame2.shot(4);
		assertEquals("5|4", frame2.getCurrentScoreBoard());

		Frame frame3 = new Frame();
		frame3.shot(10);
		assertEquals("X", frame3.getCurrentScoreBoard());
	}

	@Test(expected = InvalidFinFalledException.class)
	public void nomalFrameScoreExceptionTest() {
		Frame frame3 = new Frame();
		frame3.shot(10);
		frame3.shot(4);
	}

	@Test(expected = InvalidFrameScoreException.class)
	public void nomalFrameScoreExceptionTest2() {
		Frame frame3 = new Frame();
		frame3.shot(3);
		frame3.shot(4);
		frame3.shot(4);
	}
}
