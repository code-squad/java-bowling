package state;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bowling.Frame;
import state.NormalFrame;
import state.NormalRoll;
import state.Ready;
import state.State;
import state.Strike;

public class StateTest {

	Frame frame;

	@Before
	public void setting() {
		frame = new Frame();
	}

	@Test
	public void strike_State_Test() {
		State state = frame.getState();
		assertTrue(state instanceof Ready);
		frame.roll(10);
		state = frame.getState();
		assertTrue(state instanceof Strike);
	}

	@Test
	public void NormalRoll_State_Test() {
		State state = frame.getState();
		assertTrue(state instanceof Ready);
		frame.roll(5);
		state = frame.getState();
		assertTrue(state instanceof NormalRoll);
	}

	@Test
	public void NormalFrame_State_Test() {
		State state = frame.getState();
		assertTrue(state instanceof Ready);
		frame.roll(5);
		frame.roll(4);
		state = frame.getState();
		assertTrue(state instanceof NormalFrame);
	}
	
	@Test
	public void Spare_State_Test() {
		State state = frame.getState();
		assertTrue(state instanceof Ready);
		frame.roll(5);
		frame.roll(5);
		state = frame.getState();
		assertTrue(state instanceof Spare);
	}
}
