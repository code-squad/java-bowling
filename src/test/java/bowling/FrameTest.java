package bowling;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	private FinalFrame finalFrame;
	private Frame frame;

	@Before
	public void setUp() {
		frame = new NormalFrame(1);
	}

	@Test
	public void getSpareStatus() throws MyException {
		frame.addScore(2);
		frame.addScore(8);
		assertEquals(Status.SPARE, frame.getStatus());
	}

	@Test
	public void getStriketatus() throws MyException {
		frame.addScore(10);
		assertEquals(Status.STRIKE, frame.getStatus());
	}

	@Test
	public void getMissStatus() throws MyException {
		frame.addScore(2);
		frame.addScore(0);
		assertEquals(Status.MISSORNORMAL, frame.getStatus());
	}

}
