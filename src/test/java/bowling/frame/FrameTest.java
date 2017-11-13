package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.result.Result;

public class FrameTest {
	private static final Logger log = LoggerFactory.getLogger(FrameTest.class);

	@Test
	public void 프레임생성() {
		Frame nomalFrame = Frame.createFrame(1);
		Frame lastFrame = Frame.createFrame(10);
		assertEquals(nomalFrame, NomalFrame.create(1));
		assertEquals(lastFrame, LastFrame.create(10));
	}

	@Test
	public void 출력해보기() {
		Frame frame = Frame.createFrame(1);
		Frame next;
		next = frame.bowl(2);
		next = next.bowl(3);
		next = next.bowl(10);
		next = next.bowl(1);
		next = next.bowl(9);
		Result result = frame.result();
		log.debug(result.show("wsh"));
	}
}
