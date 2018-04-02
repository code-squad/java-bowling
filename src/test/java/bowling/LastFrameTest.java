package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import state.Spare;
import state.Strike;

public class LastFrameTest {
	LastFrame frame;

	@Test
	public void spareTest() {
		frame = new LastFrame(10, new Spare());
		frame.roll(6);
		assertThat(frame.getIntFirstBonusBowl(), is(6));
	}
	
	@Test
	public void strikeTest() {
		frame = new LastFrame(10, new Strike());
		frame.roll(10);
		frame.roll(5);
		assertThat(frame.getIntFirstBonusBowl(), is(10));
		assertThat(frame.getIntSecondBonusBowl(), is(5));
	}
	
	@Test(expected = EndGameException.class)
	public void lastFrameErrorTest() {
		frame = new LastFrame(10, new Strike());
		frame.roll(10);
		frame.roll(5);
		frame.roll(5);
	}	
}
