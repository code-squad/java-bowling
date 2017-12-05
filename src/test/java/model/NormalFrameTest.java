package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NormalFrameTest {
	Frame frame;
	Pin pin1, pin2, pin3;

	@Before
	public void setUp() {
		frame = new NormalFrame(1);
		pin1 = new Pin(9);
		pin2 = new Pin(1);
		pin3 = new Pin(10);
	}

	@Test
	public void 프레임이_비어있을때_끝났는지_테스트() throws Exception {
		assertEquals(false, frame.isEnd());
	}

	@Test
	public void 스트라이크일때_끝났는지_체크하는지_테스트() throws Exception {
		frame.addPins(pin3);
		assertEquals(true, frame.isEnd());
	}

	@Test
	public void 핀이_2일때_끝났는지_체크하는지_테스트() throws Exception {
		frame.addPins(pin1);
		frame.addPins(pin2);
		assertEquals(true, frame.isEnd());
	}

	@Test
	public void 기존프레임_반환_테스트() throws Exception {
		Frame sameFrame = frame.addAfterDecide(pin1);
		assertTrue(sameFrame == frame);
	}

	@Test
	public void new_NormalFrame_반환_테스트() throws Exception {
		frame.addPins(pin1);
		Frame sameFrame = frame.addAfterDecide(pin2);
		assertTrue(sameFrame != frame);
	}

	@Test
	public void new_TenthFrame_반환_테스트() throws Exception {
		Frame ninethFrame = new NormalFrame(9);
		Frame tenthFrame = ninethFrame.addAfterDecide(pin3);
		assertTrue(tenthFrame instanceof TenthFrame);
	}

}
