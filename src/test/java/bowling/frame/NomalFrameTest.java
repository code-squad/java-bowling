package bowling.frame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NomalFrameTest {

	@Test
	public void 일반프레임_생성() {
		Frame frame = Frame.create(1);
		assertEquals(new NomalFrame(1), frame);
	}

}
