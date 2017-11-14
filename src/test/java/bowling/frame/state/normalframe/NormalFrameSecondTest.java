package bowling.frame.state.normalframe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bowling.frame.Frame;
import bowling.frame.NormalFrame;
import bowling.frame.state.State;

public class NormalFrameSecondTest {

	@Test
	public void 현재_프레임_점수_출력() {
		State state = new NormalFrameReady();
		state = state.bowl(1);
		state = state.bowl(2);
		assertEquals("1|2", state.getPresentScore());
	}

	@Test
	public void 누적점수_출력() throws Exception {
		Frame frame = NormalFrame.create(1);
		Frame next = frame.bowl(2);
		next = next.bowl(3);
		assertEquals(5, frame.getFrameEndScore());
	}

}
