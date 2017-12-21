package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exception.HasNotFinishedException;

public class NormalFrameTest {
	Frame one;
	Pin pin1, pin2, pin3, pin4;

	@Before
	public void setUp() {
		one = new NormalFrame(1);
		pin1 = new Pin(9);
		pin2 = new Pin(1);
		pin3 = new Pin(10);
		pin4 = new Pin(0);
	}

	@Test
	public void 프레임이_비어있을때_끝났는지_테스트() throws Exception {
		assertEquals(false, one.isEnd());
	}

	@Test
	public void 스트라이크일때_끝났는지_체크하는지_테스트() throws Exception {
		one.addPins(pin3);
		assertEquals(true, one.isEnd());
	}

	@Test
	public void 핀이_2일때_끝났는지_체크하는지_테스트() throws Exception {
		one.addPins(pin1);
		one.addPins(pin2);
		assertEquals(true, one.isEnd());
	}

	@Test
	public void 기존프레임_반환_테스트() throws Exception {
		Frame sameFrame = one.addAfterDecide(pin1);
		assertTrue(sameFrame == one);
	}

	@Test
	public void new_NormalFrame_반환_테스트() throws Exception {
		one.addPins(pin1);
		Frame sameFrame = one.addAfterDecide(pin2);
		assertTrue(sameFrame != one);
	}

	@Test
	public void new_TenthFrame_반환_테스트() throws Exception {
		Frame ninethFrame = new NormalFrame(9);
		Frame tenthFrame = ninethFrame.addAfterDecide(pin3);
		assertTrue(tenthFrame instanceof TenthFrame);
	}

	@Test
	public void calculateScore_Strike() throws Exception {
		Frame two = one.addAfterDecide(pin3);
		Frame three = two.addAfterDecide(pin3);
		Frame four = three.addAfterDecide(pin3);
		Score oneScore = one.decide();
		Score onefinalScore = two.calculateScore(oneScore); // one 의 score.
		assertEquals(30, onefinalScore.getScore());
	}

	@Test
	public void calculateScore_Spare() throws Exception {
		one = one.addAfterDecide(pin1);
		Frame two = one.addAfterDecide(pin2);
		Frame three = two.addAfterDecide(pin3);
		Score oneScore = one.decide();
		Score onefinalScore = one.getNextFrame().calculateScore(oneScore); // one 의 score.
		assertEquals(20, onefinalScore.getScore());
	}

	@Test
	public void calculateScore_Miss() throws Exception {
		one = one.addAfterDecide(pin1);
		Frame two = one.addAfterDecide(pin4);
		Frame three = two.addAfterDecide(pin3);
		Score oneScore = one.decide();
		Score onefinalScore = one.getNextFrame().calculateScore(oneScore); // one 의 score.
		assertEquals(9, onefinalScore.getScore());
	}

	@Test(expected = HasNotFinishedException.class)
	public void calculateScore_NotEnd() throws Exception {
		one = one.addAfterDecide(pin1);
		Score oneScore = one.decide();
		Score onefinalScore = one.getNextFrame().calculateScore(oneScore); // one 의 score.
	}
}
