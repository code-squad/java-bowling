package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exception.InvalidFrameNumberException;

public class NormalFrameTest {
	Frame frame;
	Pin pin1, pin2, pin3, pin4;

	@Before
	public void setUp() {
		frame = new NormalFrame(1);
		pin1 = new Pin(9);
		pin2 = new Pin(1);
		pin3 = new Pin(10);
		pin4 = new Pin(0);
	}

	@Test
	public void 프레임이_비어있을때_끝났는지_테스트() throws Exception {
		assertEquals(false, frame.isEnd());
	}

	@Test
	public void 스트라이크일때_끝났는지_체크하는지_테스트() throws Exception {
		frame.addPins(pin3);
		assertEquals(true, frame.isEnd());
	}

	@Test
	public void 핀이_2일때_끝났는지_체크하는지_테스트() throws Exception {
		frame.addPins(pin1);
		frame.addPins(pin2);
		assertEquals(true, frame.isEnd());
	}

	@Test
	public void 기존프레임_반환_테스트() throws Exception {
		Frame sameFrame = frame.addAfterDecide(pin1);
		assertTrue(sameFrame == frame);
	}

	@Test
	public void new_NormalFrame_반환_테스트() throws Exception {
		frame.addPins(pin1);
		Frame sameFrame = frame.addAfterDecide(pin2);
		assertTrue(sameFrame != frame);
	}

	@Test
	public void new_TenthFrame_반환_테스트() throws Exception {
		Frame ninethFrame = new NormalFrame(9);
		Frame tenthFrame = ninethFrame.addAfterDecide(pin3);
		assertTrue(tenthFrame instanceof TenthFrame);
	}

	@Test
	public void strike_일때_returnNull_테스트() throws Exception {
		frame.addAfterDecide(pin3);
		String score = frame.createScore();
		assertEquals("", score);
	}

	@Test
	public void strike_이고_다음프레임_spare일때_점수생성_테스트() throws Exception {
		frame.addAfterDecide(pin3);
		Frame second = frame.getNextFrame();
		second.addAfterDecide(pin1);
		second.addAfterDecide(pin2);
		String score = frame.createScore();
		assertEquals("20", score);
	}

	@Test
	public void strike_이고_다음프레임_strike일때_점수생성_테스트1() throws Exception {
		frame.addAfterDecide(pin3);
		Frame second = frame.getNextFrame();
		second.addAfterDecide(pin3);
		String score = frame.createScore();
		assertEquals("", score);
	}

	@Test
	public void strike_이고_다음프레임_strike일때_점수생성_테스트2() throws Exception {
		frame.addAfterDecide(pin3);
		Frame second = frame.getNextFrame();
		second.addAfterDecide(pin3);
		Frame third = second.getNextFrame();
		third.addAfterDecide(pin3);
		String score = frame.createScore();
		assertEquals("30", score);
	}

	@Test
	public void spare_일때_returnNull_테스트() throws Exception {
		frame.addAfterDecide(pin1);
		frame.addAfterDecide(pin2);
		String score = frame.createScore();
		assertEquals("", score);
	}

	@Test
	public void spare_일때_returnScore_테스트() throws Exception {
		frame.addAfterDecide(pin1);
		frame.addAfterDecide(pin2);
		Frame second = frame.getNextFrame();
		second.addAfterDecide(pin3);
		String score = frame.createScore();
		assertEquals("20", score);
	}

	@Test
	public void miss_일때_returnScore_테스트() throws Exception {
		frame.addAfterDecide(pin1);
		frame.addAfterDecide(pin4);
		String score = frame.createScore();
		assertEquals("9", score);
	}

	@Test
	public void whenIsStrikeTest() throws Exception {
		frame.whenIsStrike();
	}

	@Test
	public void 열번째_프레임_점수_생성_테스트() throws Exception {
		Frame frame = new NormalFrame(9);
		frame.addAfterDecide(pin3);
		Frame ten = frame.getNextFrame();
		try {
			for (int i = 0; i < 3; i++) {
				ten.addAfterDecide(pin3);
			}
		} catch (InvalidFrameNumberException e) {
			String score = ten.createScore();
			assertEquals("30", score);
		}
	}

	@Test
	public void 열번째_프레임_점수_생성_테스트2() throws Exception {
		Frame frame = new NormalFrame(9);
		frame.addAfterDecide(pin3);
		Frame ten = frame.getNextFrame();
		try {
			for (int i = 0; i < 3; i++) {
				ten.addAfterDecide(pin3);
			}
		} catch (InvalidFrameNumberException e) {
			String score1 = frame.createScore();
			String score2 = ten.createScore();
			assertEquals("30", score1);
			assertEquals("30", score2);
		}
	}
}
