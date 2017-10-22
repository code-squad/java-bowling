package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void 다음_프레임을_추가하자() {
		Frame frame = new Frame(1);
		Frame nextFrame = frame.bowl(10);
		assertEquals(2, nextFrame.getNo());
	}
}
