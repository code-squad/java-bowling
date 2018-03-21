package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NomalFrameTest {
	Frame frame;

	@Before
	public void setting() {
		frame = new NomalFrame(1);
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
		assertThat(frame.getCurrentFrame().toString(), is("Frame [frameNo=10]"));
	}

	@Test
	public void StrikeFrameTest() {
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(10));
		assertThat(frame.getFirstRoll(), is(10));
		assertThat(frame.getSecondRoll(), is(0));
		assertThat(frame.toString(), is("Frame [frameNo=1]"));
		assertThat(frame.getCurrentFrame().toString(), is("Frame [frameNo=3]"));
	}
	
	@Test
	public void StrikeSpareNomalFrameTest() {
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(5));
		frame.InputBowl(new Pins(5));
		frame.InputBowl(new Pins(10));
		frame.InputBowl(new Pins(4));
		frame.InputBowl(new Pins(4));
		assertThat(frame.getFirstRoll(), is(10));
		assertThat(frame.getSecondRoll(), is(0));
		assertThat(frame.toString(), is("Frame [frameNo=1]"));
		assertThat(frame.getCurrentFrame().toString(), is("Frame [frameNo=5]"));
	}
}
