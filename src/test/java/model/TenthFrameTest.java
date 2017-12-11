package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exception.InvalidFrameNumberException;

public class TenthFrameTest {
	TenthFrame t;
	Pin pin1, pin2, pin3, pin4;

	@Before
	public void setUp() {
		t = new TenthFrame(10);
		pin1 = new Pin(9);
		pin2 = new Pin(1);
		pin3 = new Pin(10);
		pin4 = new Pin(0);
	}

	@Test(expected = InvalidFrameNumberException.class)
	public void 예외발생_확인() throws RuntimeException {
		t = new TenthFrame(10);
		Pin pin;
		for (int i = 0; i < 4; i++) {
			pin = new Pin(10);
			t.addAfterDecide(pin);
		}

	}

	@Test
	public void strike_일때_returnNull_테스트() throws Exception {
		t.addAfterDecide(pin3);
		String score = t.createScore();
		assertEquals("", score);
	}

	@Test
	public void twoStrike_일때_returnNull_테스트() throws Exception {
		try {
			t.addAfterDecide(pin3);
			t.addAfterDecide(pin3);
		} catch (InvalidFrameNumberException e) {
			String score = t.createScore();
			assertEquals("", score);
		}
	}

	@Test
	public void threeStrike_일때_returnSxtcore_테스트() throws Exception {
		try {
			t.addPins(pin3);
			t.addPins(pin3);
			t.addAfterDecide(pin3);
		} catch (InvalidFrameNumberException e) {
			String score = t.createScore();
			assertEquals("30", score);
		}
	}

	@Test
	public void spare_일때_returnScore_테스트() throws Exception {
		try {
			t.addPins(pin1);
			t.addPins(pin2);
			t.addAfterDecide(pin3);
		} catch (InvalidFrameNumberException e) {
			String score = t.createScore();
			assertEquals("20", score);
		}
	}

	@Test
	public void miss_일때_returnScore_테스트() throws Exception {
		try {
			t.addAfterDecide(pin1);
			t.addAfterDecide(pin4);
		} catch (InvalidFrameNumberException e) {
			String score = t.createScore();
			assertEquals("9", score);
		}
	}

}
