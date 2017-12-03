package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NormalFrameTest {
	Frame frame;

	@Before
	public void setUp() {
		frame = new NormalFrame(1);
	}

	@Test
	public void decideStatusTest() throws Exception {
		Pin pin1 = new Pin(1);
		Pin pin2 = new Pin(9);
		frame.addPins(pin1);
		frame.addPins(pin2);
		String status = frame.decideStatus();
		assertEquals("1|/", status);
	}

	@Test
	public void 새_프레임_생성_테스트() throws Exception {
		frame.addPins(1);
		frame.addPins(9);
////		Frame newFrame = frame.returnFrame();
//		assertTrue(newFrame != frame);
//		assertEquals(1, frame.getFrameNum());
//		assertEquals(2, newFrame.getFrameNum());

		Frame secondFrame = new NormalFrame(2);
		secondFrame.addPins(1);
////		Frame sameFrame = secondFrame.returnFrame();
//		assertTrue(sameFrame == secondFrame);
//		assertEquals(2, sameFrame.getFrameNum());

	}
}
