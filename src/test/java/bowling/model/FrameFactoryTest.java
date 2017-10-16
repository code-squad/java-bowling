package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameFactoryTest {

	@Test
	public void 프레임들을_만들어_주자() {
		Frame frame = FrameFactory.initFrames();
		assertEquals(10, frame.size());
	}
}
