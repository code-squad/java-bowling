package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	Bowling bowling;

	@Before
	public void setUp() {
		bowling = new Bowling();
	}

	@Test
	public void bowl_테스트() {

		bowling.addFirstFrame();
		int falledPin1 = 10;
		bowling.bowl(falledPin1);
		assertEquals(2, bowling.getFrames().size());
		assertEquals(1, bowling.getFrames().get(0).getFrameNum());
		assertEquals(2, bowling.getFrames().get(1).getFrameNum());
		assertFalse(bowling.currentFrame.isEnd());

		int falledPin2 = 1;
		bowling.bowl(falledPin2);
		assertEquals(2, bowling.getFrames().size());
		assertEquals(1, bowling.getFrames().get(0).getFrameNum());
		assertEquals(2, bowling.getFrames().get(1).getFrameNum());
		assertEquals(2, bowling.currentFrame.getFrameNum());
		assertFalse(bowling.currentFrame.isEnd());

		int falledPin3 = 9;
		bowling.bowl(falledPin3);
		assertEquals(3, bowling.getFrames().size());
		assertEquals(1, bowling.getFrames().get(0).getFrameNum());
		assertEquals(2, bowling.getFrames().get(1).getFrameNum());
		assertEquals(3, bowling.getFrames().get(2).getFrameNum());
		assertEquals(3, bowling.currentFrame.getFrameNum());
		assertFalse(bowling.currentFrame.isEnd());

		int falledPin4 = 3;
		bowling.bowl(falledPin4);
		assertEquals(3, bowling.getFrames().size());
		assertEquals(3, bowling.getFrames().get(2).getFrameNum());
		assertEquals(3, bowling.currentFrame.getFrameNum());
		assertFalse(bowling.currentFrame.isEnd());

	}

	@Test
	public void 열번째_프레임생성_테스트() throws Exception {
		int falledPin = 10;
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);
		bowling.bowl(falledPin);

		assertEquals("X", bowling.getFrames().get(8).decideStatus());
		assertEquals("X", bowling.getFrames().get(9).decideStatus());

	}

}
