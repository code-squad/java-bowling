package bowling.model.frame;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.frame.Frame;
import bowling.model.frame.LastFrame;

public class LastFrameTest {

	@Test
	public void 일반적인_점수_출력() {
		Frame frame = new LastFrame();
		frame = frame.bowl(5);
		frame = frame.bowl(3);
		frame.calculate(0);
		assertEquals(8, frame.getScore());
	}

	@Test
	public void 스트라이크_점수_출력() {
		Frame frame = new LastFrame();
		frame = frame.bowl(10);
		frame = frame.bowl(4);
		frame = frame.bowl(10);
		frame.calculate(0);
		assertEquals(24, frame.getScore());
	}

	@Test
	public void 스페어_점수_출력() {
		Frame frame = new LastFrame();
		frame = frame.bowl(6);
		frame = frame.bowl(4);
		frame = frame.bowl(3);
		frame.calculate(0);
		assertEquals(13, frame.getScore());
	}

}
