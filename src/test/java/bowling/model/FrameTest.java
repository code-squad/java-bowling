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
		frame.calculateSumScore();
		frame.setScore("2");
		frame.setScore("5");
		frame.calculateSumScore();
		frame.setScore("1");
		frame.setScore("6");
		frame.calculateSumScore();
		frame.setScore("3");
		frame.setScore("4");
		frame.calculateSumScore();
		assertEquals("22", frame.getSumScore());

		frame = FrameFactory.initFrames();
		frame.setScore("1");
		frame.setScore("0");
		frame.calculateSumScore();
		frame.setScore("2");
		frame.setScore("5");
		frame.calculateSumScore();
		frame.setScore("1");
		frame.setScore("6");
		frame.calculateSumScore();
		assertEquals("15", frame.getSumScore());
	}

	@Test
	public void 스페어가_있을때_점수_구하기() {
		Frame frame = FrameFactory.initFrames();
		frame.setScore("3");
		frame.setScore("2");
		frame.calculateSumScore();
		assertEquals("5", frame.getSumScore());
		frame.setScore("7");
		frame.setScore("3");
		frame.calculateSumScore();
		assertEquals("   ", frame.getSumScore());
		frame.setScore("3");
		frame.setScore("5");
		frame.calculateSumScore();
		frame.calculateSumScore();
		assertEquals("26", frame.getSumScore());
	}

	@Test
	public void 스트라이크가_있을때_점수_구하기() {
		Frame frame = FrameFactory.initFrames();
		frame.setScore("3");
		frame.setScore("2");
		frame.calculateSumScore();
		assertEquals("5", frame.getSumScore());
		frame.setScore("10");
		frame.calculateSumScore();
		assertEquals("   ", frame.getSumScore());
		frame.setScore("3");
		frame.setScore("5");
		frame.calculateSumScore();
		assertEquals("31", frame.getSumScore());
	}

	@Test
	public void 삼백점_테스트() {
		Frame frame = FrameFactory.initFrames();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.calculateSumScore();
		frame.setScore("10");
		frame.setScore("10");
		frame.setScore("10");
		frame.calculateSumScore();
		assertEquals("300", frame.getSumScore());
	}
}
