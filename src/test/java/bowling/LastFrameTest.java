package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LastFrameTest {
	LastFrame frame;

	@Before
	public void setting() {
		frame = new LastFrame(10);
	}

	@Test
	public void spareTest() {
		frame.roll(6);
		frame.roll(4);
		frame.roll(5);
		assertThat(frame.getFirstRoll(), is(6));
		assertThat(frame.getSecondRoll(), is(4));
		assertThat(frame.getBonusBowl(), is(5));
	}
	
	@Test
	public void strikeTest() {
		frame.roll(10);
		frame.roll(5);
		frame.roll(5);
		assertThat(frame.getFirstRoll(), is(10));
		assertThat(frame.getSecondRoll(), is(5));
		assertThat(frame.getBonusBowl(), is(5));
	}
	
	@Test(expected = EndGameException.class)
	public void lastFrameErrorTest() {
		frame.roll(10);
		frame.roll(5);
		frame.roll(5);
		frame.roll(5);
	}
}
