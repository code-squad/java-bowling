package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	private FinalFrame finalFrame;
	private Frame frame;

	@Before
	public void setUp(){
		frame = new Frame(0);
		finalFrame = new FinalFrame(0);
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
		assertEquals("|" + "3", frame.changeFormat());
	}

	@Test
	public void finalFrameStrike() {
		finalFrame.addScore(10);
		assertEquals(true, finalFrame.isNotEnd());
		assertEquals(Status.STRIKE, finalFrame.getStatus());
	}

	@Test
	public void finalFrameSpare() {
		finalFrame.addScore(6);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(4);
		assertEquals(true, finalFrame.isNotEnd());
		assertEquals(Status.SPARE, finalFrame.getStatus());

	}

	@Test
	public void finalFrameMiss() {
		finalFrame.addScore(3);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(0);
		assertEquals(false, finalFrame.isNotEnd());
		assertEquals(Status.MISSORNORMAL, finalFrame.getStatus());

	}

	@Test
	public void finalFrameNormal() {
		finalFrame.addScore(3);
		assertEquals(true, finalFrame.isNotEnd());
		finalFrame.addScore(4);
		assertEquals(false, finalFrame.isNotEnd());
		assertEquals(Status.MISSORNORMAL, finalFrame.getStatus());

	}

	@Test
	public void isEnd() {
		finalFrame.addScore(8);
		assertEquals(true, finalFrame.isNotEnd());
	}
	
	@Test
	public void makeFrameScoreTest() {
		frame.addScore(3);
		frame.addScore(7);
		frame.addScore(2);
		
		//assertEquals(12, frame.makeFrameScore());
	}
	
	@Test
	public void isNextExistTest() {
		frame.addScore(4);
		frame.addScore(6);
		frame.addScore(3);
		//assertEquals(false, frame.isNextExist());
	}
}