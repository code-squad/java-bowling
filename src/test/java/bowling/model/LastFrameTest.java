package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LastFrameTest {

	@Test
	public void 마지막_프레임_스트라이크_처리() {
		LastFrame lf = new LastFrame();
		lf.setScore("10");
		lf.setScore("10");
		lf.setScore("10");
		lf.calculateSumScore("11");
		assertEquals("41", lf.getSumScore());
	}

	@Test
	public void 마지막_프레임_스페어_처리() {
		LastFrame lf = new LastFrame();
		lf.setScore("3");
		lf.setScore("7");
		lf.setScore("4");
		lf.calculateSumScore("11");
		assertEquals("25", lf.getSumScore());
	}

	@Test
	public void 마지막_프레임_스페어와_스트라이크_혼합_처리() {
		LastFrame lf = new LastFrame();
		lf.setScore("3");
		lf.setScore("7");
		lf.setScore("10");
		lf.calculateSumScore("11");
		assertEquals("31", lf.getSumScore());
	}

	@Test
	public void 마지막_프레임_일반_점수_처리() {
		LastFrame lf = new LastFrame();
		lf.setScore("2");
		lf.setScore("5");
		lf.calculateSumScore("11");
		assertEquals("18", lf.getSumScore());
	}

}
