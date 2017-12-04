package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TenthFrameTest {

	@Test
	public void isEnd_테스트() {
		TenthFrame tenthFrame1 = new TenthFrame(10);
		tenthFrame1.addPins(10);
		tenthFrame1.addPins(10);
		assertEquals(true, tenthFrame1.isEnd());

		TenthFrame tenthFrame2 = new TenthFrame(10);
		tenthFrame2.addPins(9);
		tenthFrame2.addPins(1);
		tenthFrame2.addPins(3);
		assertEquals(true, tenthFrame2.isEnd());

		TenthFrame tenthFrame3 = new TenthFrame(10);
		tenthFrame3.addPins(2);
		tenthFrame3.addPins(2);
		assertEquals(true, tenthFrame3.isEnd());

		TenthFrame tenthFrame4 = new TenthFrame(10);
		tenthFrame4.addPins(10);
		tenthFrame4.addPins(1);
		tenthFrame4.addPins(2);
		assertEquals(true, tenthFrame4.isEnd());

	}

}
