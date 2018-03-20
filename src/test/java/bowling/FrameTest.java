package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	Frame frame;

	@Before
	public void setting() {
		frame = new NomalFrame(1);
	}

	@Test
	public void firstRollTest() {
		frame.InputBowl(new Pins(4));
		assertThat(frame.getFirstRoll(), is(4));
	}

	@Test
	public void secondRollTest() {
		frame.InputBowl(new Pins(4));
		frame.InputBowl(new Pins(5));
		assertThat(frame.getFirstRoll(), is(4));
		assertThat(frame.getSecondRoll(), is(5));
	}

	@Test
	public void createNextFrameTest() {
		frame.InputBowl(new Pins(4));
		frame.InputBowl(new Pins(5));
		frame.InputBowl(new Pins(3));
		assertThat(frame.getFirstRoll(), is(4));
		assertThat(frame.getSecondRoll(), is(5));
		assertThat(frame.toString(), is("Frame [frameNo=1]"));
		assertThat(frame.getNextFrame().toString(), is("Frame [frameNo=2]"));
	}

	@Test
	public void inputAllNomalFrame() {
		for (int i = 0; i < 20; i++) {
			frame.InputBowl(new Pins(4));
		}

		assertThat(frame.getNextFrame().getNextFrame().getNextFrame().getNextFrame().toString(),
				is("Frame [frameNo=5]"));
		assertThat(frame.getNextFrame().getNextFrame().getNextFrame().getNextFrame().getNextFrame().getNextFrame()
				.getNextFrame().getNextFrame().getNextFrame().toString(), is("Frame [frameNo=10]"));
	}
}
