package bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NomalFrameTest {
	Frame frame;

	@Before
	public void setting() {
		frame = new NormalFrame(1);
	}

	@Test
	public void createNextFrameTest() {
		frame.roll(4);
		frame.roll(5);
		frame.roll(3);
		assertThat(frame.getFirstRoll(), is(4));
		assertThat(frame.getSecondRoll(), is(5));
		assertThat(frame.toString(), is("Frame [frameNo=1]"));
		assertThat(frame.getCurrentFrame().toString(), is("Frame [frameNo=2]"));
	}

	@Test
	public void inputAllNomalFrame() {
		for (int i = 0; i < 20; i++) {
			frame.roll(4);
		}
		assertThat(frame.getCurrentFrame().toString(), is("Frame [frameNo=10]"));
	}

	@Test
	public void StrikeFrameTest() {
		frame.roll(10);
		frame.roll(10);
		frame.roll(10);
		assertThat(frame.getFirstRoll(), is(10));
		assertThat(frame.toString(), is("Frame [frameNo=1]"));
		assertThat(frame.getCurrentFrame().toString(), is("Frame [frameNo=4]"));
	}

	@Test
	public void StrikeSpareNomalFrameTest() {
		frame.roll(10);
		frame.roll(10);
		frame.roll(5);
		frame.roll(5);
		frame.roll(10);
		frame.roll(4);
		frame.roll(4);
		assertThat(frame.getFirstRoll(), is(10));
		assertThat(frame.toString(), is("Frame [frameNo=1]"));
		assertThat(frame.getCurrentFrame().toString(), is("Frame [frameNo=6]"));
	}
}
