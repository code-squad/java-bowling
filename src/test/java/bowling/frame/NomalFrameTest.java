package bowling.frame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NomalFrameTest {

	@Test
	public void 프레임_생성() {
		Frame frame = Frame.create(1);
		assertEquals(frame, new NomalFrame(1));

		frame = Frame.create(9);
		assertEquals(frame, new NomalFrame(9));
	}

}
