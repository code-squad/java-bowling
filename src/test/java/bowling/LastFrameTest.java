package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LastFrameTest {
	LastFrame frame;

	@Before
	public void setting() {
		frame = new LastFrame(new FrameNo(10));
	}

	@Test
	public void spareTest() {
		frame.roll(new Pins(5));
		frame.roll(new Pins(5));
		frame.roll(new Pins(3));
		assertThat(frame.getFirstRoll(), is(5));
		assertThat(frame.getSecondRoll(), is(5));
		assertThat(frame.getBonusBowl(), is(3));
	}
	
	@Test
	public void strikeTest() {
		frame.roll(new Pins(10));
		frame.roll(new Pins(5));
		frame.roll(new Pins(5));
		assertThat(frame.getFirstRoll(), is(10));
		assertThat(frame.getSecondRoll(), is(5));
		assertThat(frame.getBonusBowl(), is(5));
	}
	
	@Test(expected = EndGameException.class)
	public void lastFrameErrorTest() {
		frame.roll(new Pins(10));
		frame.roll(new Pins(5));
		frame.roll(new Pins(5));
		frame.roll(new Pins(5));
	}
}
