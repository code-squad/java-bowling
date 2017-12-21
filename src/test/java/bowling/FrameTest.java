package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	private FinalFrame finalFrame;
	private Frame frame;

	@Before
	public void setUp() {
		frame = new NormalFrame();
	}

	@Test
	public void getSpareStatus() {
		frame.addScore(2);
		frame.addScore(8);
		assertEquals(Status.SPARE, frame.getStatus());
	}

	@Test
	public void getStriketatus() {
		frame.addScore(10);
		assertEquals(Status.STRIKE, frame.getStatus());
	}

	@Test
	public void getMissStatus() {
		frame.addScore(2);
		frame.addScore(0);
		assertEquals(Status.MISSORNORMAL, frame.getStatus());
	}

	@Test
	public void getNormalStatus() {
		frame.addScore(2);
		frame.addScore(3);
		assertEquals(" | " + "3" + "\t|", frame.changeFormat());
	}

}
