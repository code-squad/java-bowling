package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import frame.Frame;
import frame.NullObjectFrame;
import frame.SpareLastFrame;
import frame.StrikeLastFrame;
import state.Strike;

public class LastFrameTest {
	Frame frame;

	@Test
	public void strike_Strike_Test() {
		frame = new StrikeLastFrame();
		frame.roll(10);
		frame.roll(10);
		assertThat(frame.getFirstRoll().getPinsDown(), is(10));
		assertThat(frame.getSecondRoll().getPinsDown(), is(10));
	}
	
	@Test
	public void strike_Normal_Test() {
		frame = new StrikeLastFrame();
		frame.roll(6);
		frame.roll(7);
		assertThat(frame.getFirstRoll().getPinsDown(), is(6));
		assertThat(frame.getSecondRoll().getPinsDown(), is(7));
	}
	
	@Test
	public void spare_Strike_Test() {
		frame = new SpareLastFrame();
		frame.roll(10);
		assertThat(frame.getFirstRoll().getPinsDown(), is(10));
	}
	
	@Test
	public void spare_Normal_Test() {
		frame = new SpareLastFrame();
		frame.roll(6);
		assertThat(frame.getFirstRoll().getPinsDown(), is(6));
	}
	
	@Test(expected = EndGameException.class)
	public void lastFrameErrorTest() {
		frame = new NullObjectFrame();
		frame.roll(10);
	}	
}
