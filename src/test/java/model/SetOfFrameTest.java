package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidFrameException;

public class SetOfFrameTest {

	@Test
	public void setOfFrameFirstFrameTest() {
		SetOfFrame setOfFrame = new SetOfFrame(2);
		setOfFrame.shot(1);
		setOfFrame.shot(1);
		setOfFrame.shot(1);
		setOfFrame.shot(1);
		assertEquals(4, setOfFrame.getTotalScore());
	}

	@Test(expected = InvalidFrameException.class)
	public void setOfFrameFirstFrameExceptionTest() {
		SetOfFrame setOfFrame = new SetOfFrame(2);
		setOfFrame.shot(1);
		setOfFrame.shot(1);
		setOfFrame.shot(1);
		setOfFrame.shot(1);
		setOfFrame.shot(1);
		assertEquals(4, setOfFrame.getTotalScore());
	}

	@Test
	public void setOfFrameTest() {
		SetOfFrame setOfFrame = new SetOfFrame(3);
		setOfFrame.shot(10);
		assertEquals(10, setOfFrame.getTotalScore());
		setOfFrame.shot(10);
		assertEquals(30, setOfFrame.getTotalScore());
		setOfFrame.shot(10);
		assertEquals(60, setOfFrame.getTotalScore());
		setOfFrame.shot(10);
		setOfFrame.shot(10);
		assertEquals(90, setOfFrame.getTotalScore());
	}

	@Test
	public void setOfFrameTest2() {
		SetOfFrame setOfFrame = new SetOfFrame(2);
		setOfFrame.shot(10);
		setOfFrame.shot(2);
		assertEquals(14, setOfFrame.getTotalScore());
		setOfFrame.shot(3);
		assertEquals(20, setOfFrame.getTotalScore());
	}
}