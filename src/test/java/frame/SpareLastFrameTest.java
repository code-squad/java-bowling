package frame;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import state.FirstRoll;
import state.Spare;

public class SpareLastFrameTest {

	Frame frame;
	
	@Before
	public void setting() {
		frame = new NormalFrame();
		for (int i = 0; i < 18; i++) {
			frame.roll(4);
		}
	}
	
//	@Test
//	public void constructor_parameter_test_when_spare() {
//		frame.roll(4);
//		frame = frame.roll(6);
//		frame.roll(6);
//		assertTrue(frame.getFrameInfo().getState() instanceof Spare);
//	}
	
	@Test
	public void isGameEnd_test_when_spare() {
		frame.roll(4);
		frame.roll(6);
		frame = frame.roll(6);
		assertTrue(frame.isGameEnd());
	}

}
