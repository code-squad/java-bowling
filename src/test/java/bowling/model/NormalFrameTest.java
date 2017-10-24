package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.state.last.LastReady;

public class NormalFrameTest {

	@Test
	public void 일반적인_다음_Frame_추가() {
		Frame frame = new NormalFrame(1);
		frame = frame.bowl(3);
		assertEquals(1, frame.getNo());
		Frame nextFrame = frame.bowl(4);
		assertEquals(2, nextFrame.getNo());
	}

	@Test
	public void 스페어로_다음_Frame_추가() {
		Frame frame = new NormalFrame(1);
		frame = frame.bowl(3);
		assertEquals(1, frame.getNo());
		Frame nextFrame = frame.bowl(7);
		assertEquals(2, nextFrame.getNo());
	}

	@Test
	public void 스트라이크로_다음_Frame_추가() {
		Frame frame = new NormalFrame(1);
		Frame nextFrame = frame.bowl(10);
		assertEquals(2, nextFrame.getNo());
	}
	
	@Test
	public void 누적_점수_확인() {
		Frame first = new NormalFrame(1);
		Frame next = first.bowl(10);
		next = next.bowl(3);
		next = next.bowl(5);
		assertEquals(18,first.getScore());
	}
	
	@Test
	public void 열번의_입력_점수_확인() {
		Frame first = new NormalFrame(1);
		Frame next = first.bowl(3);
		next = next.bowl(4);
		for(int i = 0; i < 9; i++) {
			next = next.bowl(3);
			next = next.bowl(4);
		}
		assertEquals(70,first.getScore());
	}
	
	@Test
	public void 스트라이크_열번_점수_확인() {
		Frame first = new NormalFrame(1);
		Frame next = first.bowl(10);
		for(int i = 0; i < 11; i++) {
			next = next.bowl(10);
		}
		assertEquals(120,first.getScore());
	}

}
