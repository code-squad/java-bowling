package frame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	Frame frame;

	@Before
	public void setting() {
		frame = new NormalFrame();
	}

//	@Test
//	public void input_pinsDown_twoTimes_and_save_them() {
//		frame.roll(4);
//		frame.roll(5);
//		assertThat(frame.getFrameInfo().getFirstRoll(), is(4));
//		assertThat(frame.getFrameInfo().getSecondRoll(), is(5));
//	}
//
//	@Test
//	public void calculate_total_normal() {
//		frame.roll(4);
//		frame.roll(5);
//		int totalScore = frame.getFrameInfo().getFrameScore();
//		assertThat(totalScore, is(9));
//
//		frame.roll(3);
//		frame = frame.roll(4);
//		totalScore = frame.getFrameInfo().getTotalScore().getScore();
//		assertThat(totalScore, is(7));
//	}
//
//	@Test
//	public void getCurrentFrame_test() {
//		frame.roll(4);
//		frame.roll(4);
//		frame.roll(4);
//		frame.roll(4);
//		frame = frame.roll(4);
//		assertThat(frame.getFrameInfo().getFrameNo(), is(3));
//	}
//
//	@Test
//	public void set_allFrame_roll() {
//		for (int i = 0; i < 20; i++) {
//			frame.roll(4);
//		}
//		assertThat(frame.getFrameInfo().getFirstRoll(), is(4));
//	}
//
//	@Test
//	public void lastFrame_end_test_when_miss() {
//		for (int i = 0; i < 19; i++) {
//			frame.roll(4);
//		}
//		frame = frame.roll(4);
//		assertTrue(((NormalFrame) frame).isLastFrame());
//		assertTrue(((NormalFrame) frame).needExtraFrame());
//		assertTrue(frame.isGameEnd());
//	}
//	
//	@Test
//	public void lastFrame_end_test_when_spare() {
//		for (int i = 0; i < 18; i++) {
//			frame.roll(4);
//		}
//		frame.roll(4);
//		frame = frame.roll(6);
//		
//		assertTrue(((NormalFrame) frame).isLastFrame());
//		assertTrue(!((NormalFrame) frame).needExtraFrame());
//		assertTrue(!frame.isGameEnd());
//		
//		frame.roll(5);
//		assertTrue(frame.getFrameInfo().getNextFrame() instanceof SpareLastFrame);
//	}
//	
//	@Test
//	public void lastFrame_nextFrame_tSest_when_spare() {
//		for (int i = 0; i < 18; i++) {
//			frame.roll(4);
//		}
//		frame.roll(4);
//		frame = frame.roll(6);		
//		frame.roll(5);
//		assertTrue(frame.getFrameInfo().getNextFrame() instanceof SpareLastFrame);
//	}
//	
//	@Test
//	public void lastFrame_end_test_when_strike() {
//		for (int i = 0; i < 18; i++) {
//			frame.roll(4);
//		}
//		frame = frame.roll(10);
//		frame.roll(4);
//		frame.roll(4);
//		
//		assertTrue(frame.getFrameInfo().getNextFrame() instanceof SpareLastFrame);
//		assertTrue(((NormalFrame) frame).isLastFrame());
//		assertTrue(!((NormalFrame) frame).needExtraFrame());
//		assertTrue(!frame.isGameEnd());
//	}
//	
//	@Test
//	public void lastFrame_create_test_when_strike() {
//		for (int i = 0; i < 18; i++) {
//			frame.roll(4);
//		}
//		frame = frame.roll(10);
//		frame.roll(4);
//		frame.roll(4);
//		
//		assertTrue(frame.getFrameInfo().getNextFrame() instanceof StrikeLastFrame);
//	}
//	
//	@Test
//	public void lastFrame_nextFrame_test_when_spare() {
//		for (int i = 0; i < 18; i++) {
//			frame.roll(4);
//		}
//		frame.roll(4);
//		frame = frame.roll(6);		
//		frame.roll(5);
//		assertTrue(frame.getFrameInfo().getNextFrame() instanceof SpareLastFrame);
//	}
//	
}
