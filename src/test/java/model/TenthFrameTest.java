package model;

import static org.junit.Assert.*;

import org.junit.Test;

import Exception.InvalidFrameNumberException;

public class TenthFrameTest {
	TenthFrame t;

	@Test
	public void isEndTest() {

	}

	@Test(expected = InvalidFrameNumberException.class)
	public void testName() throws RuntimeException {
		t = new TenthFrame(10);
		Pin pin;
		for (int i = 0; i < 4; i++) {
			pin = new Pin(10);
			t.addAfterDecide(pin);
		}

	}

}
