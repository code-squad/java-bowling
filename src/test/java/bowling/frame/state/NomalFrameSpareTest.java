package bowling.frame.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bowling.frame.Frame;

public class NomalFrameSpareTest {

	@Test
	public void 스페이_상태일때_점수계산() {
		Frame frame = Frame.createFrame(1);
		Frame next = frame.bowl(1);
		next = next.bowl(9);
		next = next.bowl(3);
		next = next.bowl(2);
		assertEquals(13, frame.getFrameEndScore());
	}

}
