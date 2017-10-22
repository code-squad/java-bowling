package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void 일반적인_다음_Frame_추가() {
		Frame frame = new Frame(1);
		frame = frame.bowl(3);
		assertEquals(1, frame.getNo());
		Frame nextFrame = frame.bowl(4);
		assertEquals(2, nextFrame.getNo());
	}
	
	@Test
	public void 스페어로_다음_Frame_추가() {
		Frame frame = new Frame(1);
		frame = frame.bowl(3);
		assertEquals(1, frame.getNo());
		Frame nextFrame = frame.bowl(7);
		assertEquals(2, nextFrame.getNo());
	}
	
	@Test
	public void 스트라이크로_다음_Frame_추가() {
		Frame frame = new Frame(1);
		Frame nextFrame = frame.bowl(10);
		assertEquals(2, nextFrame.getNo());
	}
}
