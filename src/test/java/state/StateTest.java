package state;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import frame.Frame;
import frame.NormalFrame;

public class StateTest {

	Frame frame;

	@Before
	public void setting() {
		frame = new NormalFrame();
	}

//	@Test
//	public void strike_State_Test() {
//		State state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof Ready);
//		frame.roll(10);
//		state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof Strike);
//	}
//
//	@Test
//	public void NormalRoll_State_Test() {
//		State state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof Ready);
//		frame.roll(5);
//		state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof FirstRoll);
//	}
//
//	@Test
//	public void NormalFrame_State_Test() {
//		State state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof Ready);
//		frame.roll(5);
//		frame.roll(4);
//		state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof Miss);
//	}
//	
//	@Test
//	public void Spare_State_Test() {
//		State state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof Ready);
//		frame.roll(5);
//		frame.roll(5);
//		state = frame.getFrameInfo().getState();
//		assertTrue(state instanceof Spare);
//	}
}
