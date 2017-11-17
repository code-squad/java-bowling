package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFrameScoreException;
import model.frame.Frame;

public class NormalFrameTest {

	@Test
	public void nomalFrameScoreTest() {
		Frame normalFrame = new NormalFrame();
		normalFrame.shot(5);
		normalFrame.shot(5);
		assertEquals("5|/", normalFrame.getCurrentScoreBoard());

		Frame frame2 = new NormalFrame();
		frame2.shot(5);
		frame2.shot(4);
		assertEquals("5|4", frame2.getCurrentScoreBoard());

		Frame frame3 = new NormalFrame();
		frame3.shot(10);
		assertEquals("X", frame3.getCurrentScoreBoard());
	}


	@Test(expected = InvalidFrameScoreException.class)
	public void nomalFrameScoreExceptionTest() {
		Frame frame3 = new NormalFrame();
		frame3.shot(10);
		frame3.shot(4);
	}

	@Test(expected = InvalidFrameScoreException.class)
	public void nomalFrameScoreExceptionTest2() {
		Frame frame3 = new NormalFrame();
		frame3.shot(3);
		frame3.shot(4);
		frame3.shot(4);
	}
	
	@Test
	public void frameScoreTest() {
		Frame normalFrame = new NormalFrame();
		normalFrame.shot(3);
		normalFrame.shot(7);
		assertEquals(10, normalFrame.getFrameScore());
	}
	
	@Test
	public void frameScoreTest2() {
		Frame normalFrame = new NormalFrame();
		normalFrame.shot(3);
		normalFrame.shot(7);
		normalFrame.addBonusScore(10);
		assertEquals(20, normalFrame.getFrameScore());
	}
}
