package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	private FinalFrame finalFrame;
	private Frame frame;

	@Before
	public void setUp(){
		frame = new Frame();
		finalFrame = new FinalFrame();
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
		assertEquals(Status.MISS, frame.getStatus());
	}

	@Test
	public void getNormalStatus() {
		frame.addScore(2);
		frame.addScore(3);
		assertEquals(" | " + "3" + "\t|", frame.changeFormat());
	}

	@Test
	public void finalFrameStrike() {
		finalFrame.addScore(10);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(7);
		assertEquals(false, finalFrame.isNotEnd());
		assertEquals(null, finalFrame.getStatus());
	}

	@Test
	public void finalFrameSpare() {
		finalFrame.addScore(6);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(4);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(2);
		assertEquals(false, finalFrame.isNotEnd());
		assertEquals(Status.SPARE, finalFrame.getStatus());

	}

	@Test
	public void finalFrameMiss() {
		finalFrame.addScore(3);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(0);
		assertEquals(false, finalFrame.isNotEnd());
		assertEquals(Status.SPARE, finalFrame.getStatus());

	}

	@Test
	public void finalFrameNormal() {
		finalFrame.addScore(3);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(4);
		assertEquals(false, finalFrame.isNotEnd());
		assertEquals(Status.SPARE, finalFrame.getStatus());

	}

	@Test
	public void isEnd() {
		finalFrame.addScore(8);
		assertEquals(true, finalFrame.isNotEnd());
	}
}