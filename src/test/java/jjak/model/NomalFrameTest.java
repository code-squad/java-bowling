package jjak.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NomalFrameTest {
	Frame normalFrame;

	@Before
	public void setup() {
		normalFrame = new NomalFrame();
	}

	@Test
	public void 점수를_입력_받자() {
		normalFrame.setFirstScore(2);
		normalFrame.setSecondScore(1);
		assertEquals(2, normalFrame.getFirstScore());
		assertEquals(1, normalFrame.getSecondScore());
	}

}
