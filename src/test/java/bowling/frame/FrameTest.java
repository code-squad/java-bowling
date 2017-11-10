package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void 프레임생성() {
		Frame nomalFrame = Frame.createFrame(1);
		Frame lastFrame = Frame.createFrame(10);
		assertEquals(nomalFrame, NomalFrame.create(1));
		assertEquals(lastFrame, LastFrame.create(10));
	}
}
