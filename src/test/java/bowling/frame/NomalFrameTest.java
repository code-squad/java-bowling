package bowling.frame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bowling.user.User;

public class NomalFrameTest {

	@Test
	public void 다음_프레임을_생성하는_조건() {
		User user = User.create("wsh");
		Frame frame = Frame.createFrame(1);
		frame = frame.bowl(10);
		assertEquals(2, frame.getNo());
	}
}
