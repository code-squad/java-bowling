package state;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateTest {
	private static final Logger log = LoggerFactory.getLogger(StateTest.class);
	State state;

	@Before
	public void setting() {
		state = new Ready();
	}
	
	@Test
	public void create_Normal_Class() {
		state = state.update(4);
		assertTrue(state.getClass().getName().contains("FirstBowl"));
		state = state.update(4);
		assertTrue(state.getClass().getName().contains("Normal"));
	}
	
	@Test
	public void create_Spare_Class() {
		state = state.update(5);
		assertTrue(state.getClass().getName().contains("FirstBowl"));
		state = state.update(5+5);
		assertTrue(state.getClass().getName().contains("Spare"));
	}
	
	@Test
	public void create_Strike_Class() {
		state = state.update(10);
		assertTrue(state.getClass().getName().contains("Strike"));
	}
}