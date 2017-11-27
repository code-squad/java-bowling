import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Frame;
import model.Score;

public class FrameTest {
	Frame frame;
	Score score;
	String result;
	@Before
	public void setUp() {
		int[] pins = {10};
		score = new Score(pins);
		frame = new Frame();
		
	}
	@Test
	public void createFrameTest() throws Exception {
		frame.updateScore(score);
		Frame frame2 = frame.createFrameOrNot();
		assertTrue(frame != frame2);
		
		int[] pins2 = {9};
		score = new Score(pins2);
		frame.updateScore(score);
		Frame frame3 = frame.createFrameOrNot();
		assertTrue(frame == frame3);
//		
//		int[] pins3 = {9,1};
//		score = new Score(pins3);
//		Frame frame4 = frame.createFrame(score);
//		assertFalse(frame == frame4);	
//		assertEquals(3, Frame.getFrameNum());
	}
	@Test
	public void stillHasSpaceIn() throws Exception {
		Frame targetFrame = new Frame();
		int[] pins2 = {9};
		Score score1 = new Score(pins2); // score == 9 + ""
		targetFrame.updateScore(score1);
		boolean result = targetFrame.stillHasSpaceIn();
		assertEquals(true, result);
		
		int[] pins3 = {10};
		Score score2 = new Score(pins3);
		targetFrame.updateScore(score2);
		boolean result1 = targetFrame.stillHasSpaceIn();
		assertEquals(false, result1);
	}
}
