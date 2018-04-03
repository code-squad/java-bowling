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
		int firstRoll = 4;
		frame.roll(firstRoll);
		int secondRoll = 5;
		frame.roll(secondRoll);
		assertThat(frame.getFirstRoll().getPinsDown(), is(4));
		assertThat(frame.getSecondRoll().getPinsDown(), is(5));
	}
}
