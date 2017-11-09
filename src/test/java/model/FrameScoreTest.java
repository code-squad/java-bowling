package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidFrameScoreException;

public class FrameScoreTest {
	
	private NormalFrame frame;
	
	@Before
	public void beforeTest() {
		frame = new NormalFrame();
	}
	
	@Test
	public void shotTest() {
		frame.shot(10);
	}

	@Test(expected = InvalidFrameScoreException.class)
	public void shotScoreExceptionTest() {
		frame.shot(11);
	}
	
	@Test(expected = InvalidFrameScoreException.class)
	public void shotScoreExceptionTest_2번() {
		frame.shot(5);
		frame.shot(6);
		System.out.println(frame.getCurrentScoreBoard());
	}
	
	@Test(expected = InvalidFrameScoreException.class)
	public void shotScoreExceptionTest_3번() {
		frame.shot(5);
		frame.shot(2);
		frame.shot(2);
	}
	@Test
	public void shotStringTest() {
		
		frame.shot(5);
		assertEquals("5", frame.getCurrentScoreBoard());
		
		NormalFrame frame1 = new NormalFrame();
		frame1.shot(10);
		assertEquals("X", frame1.getCurrentScoreBoard());
		
		NormalFrame frame2 = new NormalFrame();
		frame2.shot(5);
		frame2.shot(5);
		assertEquals("5|/", frame2.getCurrentScoreBoard());
		
		NormalFrame frame3 = new NormalFrame();
		frame3.shot(5);
		frame3.shot(0);
		assertEquals("5|-", frame3.getCurrentScoreBoard());
		
		NormalFrame frame4 = new NormalFrame();
		frame4.shot(5);
		frame4.shot(3);
		assertEquals("5|3", frame4.getCurrentScoreBoard());
	}
}