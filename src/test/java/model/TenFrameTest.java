package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFinFalledException;
import exception.InvalidFrameScoreException;

public class TenFrameTest {

	@Test
	public void tenFrameTest() {
		Frame frame10 = new TenFrame();
		frame10.shot(10);
		frame10.shot(10);
		frame10.shot(10);
		assertEquals("X|X|X", frame10.getCurrentScoreBoard());
	}

	@Test
	public void tenFrameTest2() {
		Frame frame10 = new TenFrame();
		frame10.shot(5);
		frame10.shot(5);
		frame10.shot(10);
		assertEquals("5|/|X", frame10.getCurrentScoreBoard());
	}

	@Test
	public void tenFrameTest3() {
		Frame frame10 = new TenFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(5);
		assertEquals("X|5|/", frame10.getCurrentScoreBoard());
	}

	@Test
	public void tenFrameTest4() {
		Frame frame10 = new TenFrame();
		frame10.shot(5);
		frame10.shot(5);
		frame10.shot(6);
		assertEquals("5|/|6", frame10.getCurrentScoreBoard());
	}

	@Test(expected = InvalidFinFalledException.class)
	public void tenFrameShotScoreExceptionTest() {
		Frame frame10 = new TenFrame();
		frame10.shot(5);
		frame10.shot(6);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void tenFrameShotScoreExceptionTest_3번째() {
		Frame frame10 = new TenFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(6);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void tenFrameShotScoreExceptionTest_4번째() {
		Frame frame10 = new TenFrame();
		frame10.shot(5);
		frame10.shot(6);
		frame10.shot(10);
		frame10.shot(10);
	}

	@Test
	public void tenFrameScoreTest() {
		TenFrame tenFrame = new TenFrame();
		tenFrame.firstShot(10);
		tenFrame.secondShot(5);
		tenFrame.lastShot(3);
		assertEquals("X", tenFrame.getFirstValue());
		assertEquals("5", tenFrame.getSecondValue());
		assertEquals("3", tenFrame.getLastValue());
	}

	@Test(expected = InvalidFrameScoreException.class)
	public void tenFrameScoreExceptionTest() {
		TenFrame tenFrame = new TenFrame();
		tenFrame.firstShot(2);
		tenFrame.secondShot(3);
		tenFrame.lastShot(4);
	}
}