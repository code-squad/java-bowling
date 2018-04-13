package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import frame.Frame;
import frame.NormalFrame;

public class FrameTest {
	Frame frame;

	@Before
	public void setting() {
		frame = new NormalFrame();
	}

	@Test
	public void input_pinsDown_twoTimes_and_save_them() {
		frame.roll(4);
		frame.roll(5);
		assertThat(frame.getFrameInfo().getFirstRoll(), is(4));
		assertThat(frame.getFrameInfo().getSecondRoll(), is(5));
	}

	@Test
	public void calculate_total_normal() {
		frame.roll(4);
		frame.roll(5);
		int totalScore = frame.getFrameInfo().getFrameScore();
		assertThat(totalScore, is(9));

//		frame.roll(3);
//		frame = frame.roll(4);
//		totalScore = frame.getTotalScoreInt();
//		assertThat(totalScore, is(7));
	}

	@Test
	public void getCurrentFrame_test() {
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		frame = frame.roll(4);
		assertThat(frame.getFrameInfo().getFrameNo(), is(3));
	}

	@Test
	public void set_allFrame_roll() {
		for (int i = 0; i < 20; i++) {
			frame = frame.roll(4);
		}
		assertThat(frame.getFrameInfo().getFirstRoll(), is(4));
	}

	// @Test
	// public void test_method_isCalculatePreStrikeFrame_case1() {
	// Frame prmNextFrame = new Frame();
	// prmNextFrame.roll(10);
	// prmNextFrame.roll(5);
	// // prmNextFrame.roll(10);
	// assertTrue(frame.isCalculatePreStrikeFrame(prmNextFrame));
	// }

	// @Test
	// public void test_method_isCalculatePreStrikeFrame_case2() {
	// Frame prmNextFrame = new Frame();
	// prmNextFrame.roll(4);
	// // prmNextFrame.roll(5);
	// assertTrue(!frame.isCalculatePreStrikeFrame(prmNextFrame));
	// }
	//
	// @Test
	// public void test_method_isCalculatePreStrikeFrame_case3() {
	// Frame prmNextFrame = new Frame();
	// prmNextFrame.roll(10);
	// assertTrue(!frame.isCalculatePreStrikeFrame(prmNextFrame));
	// }
}
