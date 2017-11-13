package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.Frame;

public class NomalFrameStrikeTest {

	@Test
	public void 한번_스트라이크() {
		Frame frame = Frame.createFrame(1);
		Frame next = frame.bowl(10);
		next = next.bowl(3);
		next = next.bowl(7);
		assertEquals(20, frame.getFrameEndScore());
	}

	@Test
	public void 이연속_스트라이크() {
		Frame frame = Frame.createFrame(1);
		Frame next = frame.bowl(10);
		next = next.bowl(10);
		next = next.bowl(1);
		assertEquals(21, frame.getFrameEndScore());
	}

	@Test
	public void 삼연속_스트라이크() {
		Frame frame = Frame.createFrame(1);
		Frame next = frame.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		assertEquals(30, frame.getFrameEndScore());
	}

}
