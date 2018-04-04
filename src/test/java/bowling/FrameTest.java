package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	Frame frame;

	@Before
	public void setting() {
		frame = new Frame();
	}

	@Test
	public void input_pinsDown() {
		int pinsDown = 5;
		frame.roll(pinsDown);
	}

	@Test
	public void input_pinsDown_twoTimes_and_save_them() {
		frame.roll(4);
		frame.roll(5);
		assertThat(frame.getFirstRoll(), is(4));
		assertThat(frame.getSecondRoll(), is(5));
	}

	@Test
	public void calculate_total() {
		frame.roll(4);
		frame.roll(5);
		int totalScore = frame.getTotalScore();
		assertThat(totalScore, is(9));
	}

	@Test
	public void getCurrentFrame_test() {
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		frame = frame.roll(4);
		assertThat(frame.getFrameNo(), is(3));
	}

	@Test
	public void set_allFrame_roll() {
		for (int i = 0; i < 20; i++) {
			frame = frame.roll(4);
		}
		assertThat(frame.getFirstRoll(), is(4));
	}

	@Test
	public void get_eachFrame_total() {
		for (int i = 0; i < 6; i++) {
			frame.roll(4);
		}
		int total = frame.getTotalScore();
		assertThat(total, is(24));
	}
}
