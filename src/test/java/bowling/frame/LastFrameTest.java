package bowling.frame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LastFrameTest {

	private static final Logger log = LoggerFactory.getLogger(LastFrameTest.class);

	@Test
	public void 마지막프레임() {
		Frame frame = Frame.createFrame(1);
		Frame next = frame.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		assertEquals(next, Frame.createFrame(10));
	}

}
