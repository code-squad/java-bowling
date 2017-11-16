package bowling.frame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrameTest {
	@Test
	public void 프레임생성() {
		Frame nomalFrame = NormalFrame.create(1);
		Frame lastFrame = LastFrame.create(10);
		assertEquals(nomalFrame, NormalFrame.create(1));
		assertEquals(lastFrame, LastFrame.create(10));
	}
}
