package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void 프레임들을_만들자() {
		Frame frame = new Frame();
		assertEquals(1, frame.size());
	}

	@Test
	public void 프레임들을_추가하자() {
		Frame frame = new Frame();
		frame.addFrame(new Frame());
		frame.addFrame(new Frame());
		assertEquals(3, frame.size());
	}

	@Test
	public void 누적_점수_구하기() {
		Frame frame = FrameFactory.initFrames();
		frame.setScore("1");
		frame.setScore("0");
		frame.setScore("2");
		frame.setScore("5");
		frame.setScore("1");
		frame.setScore("6");
		frame.setScore("3");
		frame.setScore("4");
		frame.calculateSumScore();
		assertEquals("22", frame.getSumScore());

		frame = FrameFactory.initFrames();
		frame.setScore("1");
		frame.setScore("0");
		frame.setScore("2");
		frame.setScore("5");
		frame.setScore("1");
		frame.setScore("6");
		frame.setScore("3");
		frame.calculateSumScore();
		assertEquals("15", frame.getSumScore());
	}
}
