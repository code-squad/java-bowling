package model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Exception.InvalidFrameNumberException;

public class FrameTest {
	Frame one;
	Pin pin1, pin2, pin3, pin4;

	@Before
	public void setUp() {
		one = new NormalFrame(1);
		pin1 = new Pin(9);
		pin2 = new Pin(1);
		pin3 = new Pin(10);
		pin4 = new Pin(0);
	}

	@Test
	public void addAfterDecideTest() throws Exception {
		Frame nine = new NormalFrame(9);
		Frame ten = nine.addAfterDecide(pin3);
		assertTrue(ten instanceof TenthFrame);
	}

	@Test
	public void getNextFrameTest1() throws Exception {
		Frame seven = new NormalFrame(7);
		seven.addAfterDecide(pin3);
		assertTrue(seven.getNextFrame().getFrameNum() == 8);
		assertTrue(seven.getNextFrame().getNextFrame().getFrameNum() == 9);

	}

	@Test
	public void getNextFrameTest2() throws Exception {
		Frame eight = new NormalFrame(8);
		Frame nine = eight.addAfterDecide(pin3);
		Frame ten = nine.addAfterDecide(pin3);
		assertTrue(eight.getNextFrame().getNextFrame().getFrameNum() == 10);

	}
	@Test(expected = InvalidFrameNumberException.class)
	public void frameNumException() throws Exception {
		Frame nine = new NormalFrame(9);
		Frame ten = nine.addAfterDecide(pin3);
		ten = ten.addAfterDecide(pin3);
		ten = ten.addAfterDecide(pin3);
		Frame eleven = ten.addAfterDecide(pin3);
	}
}
