package bowling.frame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NormalFrameTest {
	@Test
	public void 다음_프레임을_생성하는_조건_스트라이크() {
		Frame frame = NormalFrame.create(1);
		frame = frame.bowl(10);
		assertEquals(2, frame.getNo());
	}

	@Test
	public void 다음_프레임을_생성하는_조건_스페어() {
		Frame frame = NormalFrame.create(1);
		frame = frame.bowl(1);
		frame = frame.bowl(2);
		assertEquals(2, frame.getNo());
	}

	@Test
	public void 다음_프레임을_생성하는_조건_미스() {
		Frame frame = NormalFrame.create(1);
		frame = frame.bowl(1);
		frame = frame.bowl(9);
		assertEquals(2, frame.getNo());
	}
}
