package frame;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import state.FirstRoll;
import state.Spare;

public class StrikeLastFrameTest {

	Frame frame;
	
	@Before
	public void setting() {
		frame = new NormalFrame();
		for (int i = 0; i < 18; i++) {
			frame.roll(4);
		}
	}
	
//	@Test
//	public void constructor_parameter_test_when_strike() {
//		frame.roll(10);
//		frame = frame.roll(6);
//		assertTrue(frame.getFrameInfo().getState() instanceof FirstRoll);
//		
//		frame = frame.roll(4);
//		assertTrue(frame.getFrameInfo().getState() instanceof Spare);
//	}
	
	@Test
	public void isGameEnd_test_when_strike_spare() {
		frame.roll(10);
		frame = frame.roll(6);
		assertTrue(!frame.isGameEnd());
		
		frame = frame.roll(4);
		assertTrue(frame.isGameEnd());
	}
	
	@Test
	public void isGameEnd_test_when_strike_miss() {
		frame.roll(10);
		frame = frame.roll(6);
		assertTrue(!frame.isGameEnd());
		
		frame = frame.roll(3);
		assertTrue(frame.isGameEnd());
	}
	
	@Test
	public void isGameEnd_test_when_strike_strike() {
		frame.roll(10);
		frame = frame.roll(10);
		assertTrue(!frame.isGameEnd());
		
		frame = frame.roll(10);
		assertTrue(frame.isGameEnd());
	}

}
