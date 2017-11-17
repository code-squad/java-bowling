package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFinFalledException;
import exception.InvalidFrameScoreException;
import model.frame.Frame;

public class LastFrameTest {

	@Test
	public void lastFrameTest() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(10);
		frame10.shot(10);
		assertEquals("X|X|X", frame10.getCurrentScoreBoard());
	}
	
	@Test
	public void lastFrameTest_1() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(10);
		frame10.shot(8);
		assertEquals("X|X|8", frame10.getCurrentScoreBoard());
	}

	@Test
	public void lastFrameTest2() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(5);
		frame10.shot(10);
		assertEquals("5|/|X", frame10.getCurrentScoreBoard());
	}

	@Test
	public void lastFrameTest3_1() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(2);
		assertEquals("X|5|2", frame10.getCurrentScoreBoard());
	}
	
	@Test
	public void lastFrameTest3() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(5);
		assertEquals("X|5|/", frame10.getCurrentScoreBoard());
	}

	@Test
	public void lastFrameTest4() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(5);
		frame10.shot(6);
		assertEquals("5|/|6", frame10.getCurrentScoreBoard());
	}
	
	@Test(expected = InvalidFrameScoreException.class)
	public void lastFrameOverScoreExceptionTest() {
		Frame frame10 = new LastFrame();
		frame10.shot(3);
		frame10.shot(2);
		frame10.shot(10);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void lastFrameShotScoreExceptionTest() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(6);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void lastFrameShotScoreExceptionTest_3번째() {
		Frame frame10 = new LastFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(6);
	}

	@Test(expected = InvalidFinFalledException.class)
	public void lastFrameShotScoreExceptionTest_4번째() {
		Frame frame10 = new LastFrame();
		frame10.shot(5);
		frame10.shot(6);
		frame10.shot(10);
		frame10.shot(10);
	}
}