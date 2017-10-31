package bowling.frame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bowling.state.Running;

public class FrameTest {

	@Test
	public void 점수입력() {
		Frame frame = Frame.create(1);
		frame.bowl(8);
		assertThat(frame.getFirstScore(), is(8));
	}

	@Test
	public void 프레임_생성_체크() throws Exception {
		Frame frame = Frame.create(1);
		assertThat(frame.getNo(), is(1));
		assertTrue(frame instanceof NomalFrame);
		assertTrue(frame.getState() instanceof Running);
		frame = Frame.create(10);
		assertTrue(frame instanceof LastFrame);
		assertTrue(frame.getState() instanceof Running);
	}
}
