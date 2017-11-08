package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Exception.FrameScoreException;

public class TestFrameScore {
	
	@Test
	public void shotTest() {
		NomalFrame frame = new NomalFrame();
		frame.shot(10);
	}

	@Test(expected = FrameScoreException.class)
	public void shotScoreExceptionTest() {
		NomalFrame frame = new NomalFrame();
		frame.shot(11);
	}
	
	@Test(expected = FrameScoreException.class)
	public void shotScoreExceptionTest_2번() {
		NomalFrame frame = new NomalFrame();
		frame.shot(5);
		frame.shot(6);
		System.out.println(frame.getCurrentScoreBoard());
	}
	
	@Test(expected = FrameScoreException.class)
	public void shotScoreExceptionTest_3번() {
		NomalFrame frame = new NomalFrame();
		frame.shot(5);
		frame.shot(2);
		frame.shot(2);
	}
	@Test
	public void shotStringTest() {
		NomalFrame frame0 = new NomalFrame();
		frame0.shot(5);
		assertEquals("5", frame0.getCurrentScoreBoard());
		NomalFrame frame1 = new NomalFrame();
		frame1.shot(10);
		assertEquals("X", frame1.getCurrentScoreBoard());
		NomalFrame frame2 = new NomalFrame();
		frame2.shot(5);
		frame2.shot(5);
		assertEquals("5|/", frame2.getCurrentScoreBoard());
		NomalFrame frame3 = new NomalFrame();
		frame3.shot(5);
		frame3.shot(0);
		assertEquals("5|-", frame3.getCurrentScoreBoard());
		NomalFrame frame4 = new NomalFrame();
		frame4.shot(5);
		frame4.shot(3);
		assertEquals("5|3", frame4.getCurrentScoreBoard());
	}
}