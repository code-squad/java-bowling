package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Exception.FrameScoreException;

public class TestTenFrame {
	
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
	
	@Test(expected = FrameScoreException.class)
	public void tenFrameShotScoreExceptionTest() {
		Frame frame10 = new TenFrame();
		frame10.shot(5);
		frame10.shot(6);
	}
	@Test(expected = FrameScoreException.class)
	public void tenFrameShotScoreExceptionTest_3번째() {
		Frame frame10 = new TenFrame();
		frame10.shot(10);
		frame10.shot(5);
		frame10.shot(6);
	}
	
	@Test(expected = FrameScoreException.class)
	public void tenFrameShotScoreExceptionTest_4번째() {
		Frame frame10 = new TenFrame();
		frame10.shot(5);
		frame10.shot(6);
		frame10.shot(10);
		frame10.shot(10);
	}
}