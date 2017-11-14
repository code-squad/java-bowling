package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFinFalledException;
import exception.InvalidFrameScoreException;

public class LastFrameTest {

	@Test
	public void tenFrameTest() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(10);
		frame10.shot(10);
		assertEquals("X|X|X", frame10.getCurrentScoreBoard());
	}
	
	@Test
	public void tenFrameTest_1() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(10);
		frame10.shot(8);
		assertEquals("X|X|8", frame10.getCurrentScoreBoard());
	}

	@Test
	public void tenFrameTest2() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(5);
		frame10.shot(10);
		assertEquals("5|/|X", frame10.getCurrentScoreBoard());
	}

	@Test
	public void tenFrameTest3_1() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(2);
		assertEquals("X|5|2", frame10.getCurrentScoreBoard());
	}
	
	@Test
	public void tenFrameTest3() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(5);
		assertEquals("X|5|/", frame10.getCurrentScoreBoard());
	}

	@Test
	public void tenFrameTest4() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(5);
		frame10.shot(6);
		assertEquals("5|/|6", frame10.getCurrentScoreBoard());
	}
	
	@Test(expected = InvalidFrameScoreException.class)
	public void tenFrameOverScoreExceptionTest() {
		Frame frame10 = new LastFrame();
		frame10.shot(3);
		frame10.shot(2);
		frame10.shot(10);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void tenFrameShotScoreExceptionTest() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(6);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void tenFrameShotScoreExceptionTest_3번째() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(6);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void tenFrameShotScoreExceptionTest_4번째() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(6);
		frame10.shot(10);
		frame10.shot(10);
	}
}