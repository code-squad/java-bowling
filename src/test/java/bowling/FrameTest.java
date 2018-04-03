package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	Frame frame;

	@Before
	public void setting() {
		frame = new Frame(1);
	}

	@Test
	public void input_pinsDown() {
		int pinsDown = 5;
		frame.roll(pinsDown);
	}

	@Test
	public void input_pinsDown_twoTimes_and_save_them() {
		int firstRoll = 4;
		frame.roll(firstRoll);
		int secondRoll = 5;
		frame.roll(secondRoll);
		assertThat(frame.getFirstRoll(), is(4));
		assertThat(frame.getSecondRoll(), is(5));
	}

	@Test
	public void calculate_total() {
		int firstRoll = 4;
		frame.roll(firstRoll);
		int secondRoll = 5;
		frame.roll(secondRoll);
		int totalScore = frame.getTotalScore();
		assertThat(9, is(9));
	}

	@Test
	public void setting_10_Frame_Object() {
		Frame frame = new Frame(1);
		for (int i = 0; i < 9; i++) {
			frame = frame.getNextFrame();
		}
		assertThat(frame.getFrameNo(), is(10));
	}

	@Test(expected = EndGameException.class)
	public void lastFrame_nextFrame_is_null() {
		Frame frame = new Frame(1);
		for (int i = 0; i < 11; i++) {
			frame = frame.getNextFrame();
		}
	}

	@Test
	public void getCurrentFrame_test() {
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		assertThat(frame.getCurrentFrame().getFrameNo(), is(3));
	}

	@Test
	public void set_allFrame_roll() {
		for (int i = 0; i < 18; i++) {
			frame.roll(4);
		}
		frame.roll(5);
		assertThat(frame.getCurrentFrame().getFirstRoll(), is(5));
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
