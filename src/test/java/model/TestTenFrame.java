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

	@Test
	public void NomalFrameScoreTest() {
		NomalFrameScore nomalFrameScore = new NomalFrameScore();
		nomalFrameScore.firstShot(5);
		nomalFrameScore.secondShot(5);
		assertEquals("5", nomalFrameScore.getFirstString());
		assertEquals("/", nomalFrameScore.getSecondString());
		
		NomalFrameScore nomalFrameScore2 = new NomalFrameScore();
		nomalFrameScore2.firstShot(5);
		nomalFrameScore2.secondShot(4);
		assertEquals("5", nomalFrameScore2.getFirstString());
		assertEquals("4", nomalFrameScore2.getSecondString());
		
		
	}
	
	@Test(expected = FrameScoreException.class)
	public void NomalFrameScoreExceptionTest() {
		NomalFrameScore nomalFrameScore3 = new NomalFrameScore();
		nomalFrameScore3.firstShot(10);
		nomalFrameScore3.secondShot(4);
	}

	@Test
	public void tenFrameScoreTest() {
		TenFrameScore tenFrameScore = new TenFrameScore();
		tenFrameScore.firstShot(10);
		tenFrameScore.secondShot(5);
		tenFrameScore.lastShot(3);
		assertEquals("X", tenFrameScore.getFirstString());
		assertEquals("5", tenFrameScore.getSecondString());
		assertEquals("3", tenFrameScore.getLastString());
	}
	
	@Test(expected = FrameScoreException.class)
	public void TenFrameScoreExceptionTest() {
		TenFrameScore tenFrameScore = new TenFrameScore();
		tenFrameScore.firstShot(2);
		tenFrameScore.secondShot(3);
		tenFrameScore.lastShot(4);
	}
}