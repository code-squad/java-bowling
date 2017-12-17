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
	public void ninethFrame_calculateScore_Strike() throws Exception {
		Frame nine = new NormalFrame(9);
		Frame ten = nine.addAfterDecide(pin3);
		ten = ten.addAfterDecide(pin3);
		ten = ten.addAfterDecide(pin3);
		Score nineScore = nine.decide();
		Score nineFinalScore = nine.getNextFrame().calculateScore(nineScore);
		assertEquals(30, nineFinalScore.getScore());
	}

	@Test
	public void ninethFrame_calculateScore_Spare() throws Exception {
		Frame nine = new NormalFrame(9);
		nine = nine.addAfterDecide(pin1);
		Frame ten = nine.addAfterDecide(pin2);
		ten = ten.addAfterDecide(pin3);
		Score nineScore = nine.decide();
		Score nineFinalScore = nine.getNextFrame().calculateScore(nineScore);
		assertEquals(20, nineFinalScore.getScore());
	}

	@Test
	public void tenthFrame_calculateScore_3Strike() throws Exception {
		Frame ten = new TenthFrame(10);
		try {
			for (int i = 0; i < 3; i++) {
				ten = ten.addAfterDecide(pin3);
			}
		} catch (InvalidFrameNumberException e) {
			Score tenScore = ten.decide();
			Score tenFinalScore = ten.calculateTenthScore(tenScore);
			assertEquals(30, tenFinalScore.getScore());
		}
	}

	@Test
	public void tenthFrame_calculateScore_1Spare() throws Exception {
		Frame ten = new TenthFrame(10);
		try {
			ten = ten.addAfterDecide(pin1);
			ten = ten.addAfterDecide(pin2);
			ten = ten.addAfterDecide(pin3);
		} catch (InvalidFrameNumberException e) {
			Score tenScore = ten.decide();
			Score tenFinalScore = ten.calculateTenthScore(tenScore);
			assertEquals(20, tenFinalScore.getScore());
		}
	}

	@Test
	public void tenthFrame_calculateScore_1Miss() throws Exception {
		Frame ten = new TenthFrame(10);
		try {
			ten = ten.addAfterDecide(pin2);
			ten = ten.addAfterDecide(pin4);
		} catch (InvalidFrameNumberException e) {
			Score tenScore = ten.decide();
			Score tenFinalScore = ten.calculateTenthScore(tenScore);
			assertEquals(1, tenFinalScore.getScore());
		}
	}
}
