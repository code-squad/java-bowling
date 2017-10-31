package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

public class LastFrameTest {

	@Test
	public void 프레임_생성() {
		Frame frame = Frame.create(10);
		assertEquals(frame, new LastFrame(10));
	}

	@Test
	public void 프레임_상태_체크() throws Exception {
		Frame frame = Frame.create(10);
		frame = frame.bowl(10);
		assertEquals(frame, new LastFrame(10));
		System.out.println(frame.getState());

	}

}
