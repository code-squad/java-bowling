package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrameTest {

	@Test
	public void addScore() {
		Frame frame = new Frame();
		frame.addScore(8);
		assertEquals(8, frame.getFrameAt(0));
	}

	@Test
	public void getSpareStatus() {
		Frame frame = new Frame();
		int score = 2;
		frame.addScore(score);
		int score2 = 8;
		frame.addScore(score2);
		assertEquals(Status.SPARE, frame.getStatus());
	}

	@Test
	public void getStriketatus() {
		Frame frame = new Frame();
		int score = 10;
		frame.addScore(score);
		assertEquals(Status.STRIKE, frame.getStatus());
	}

	@Test
	public void getNormalStatus() {
		Frame frame = new Frame();
		int score = 2;
		frame.addScore(score);
		int score2 = 3;
		frame.addScore(score2);
		assertEquals(Status.NORMAL, frame.getStatus());
	}

	@Test
	public void isEnd() {
		Frame frame = new Frame();
		int score = 8;
		frame.addScore(score);
	
		assertEquals(true, frame.isNotEnd());
	}
}
