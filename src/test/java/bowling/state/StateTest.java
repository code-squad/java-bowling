package bowling.state;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StateTest {

	@Test
	public void readyFrame_Check() {
		Ready ready = new Ready();
		State state = ready;
		assertTrue(state instanceof Ready);
		assertFalse(state.isEnd());
		assertThat(state.getFirstBowlScore(), is(0));
	}

	@Test
	public void firstFrame_Check() {
		Ready ready = new Ready();
		State state = ready.bowl(8);
		assertTrue(state instanceof First);
		assertFalse(state.isEnd());
		assertThat(state.getFirstBowlScore(), is(8));
	}

	@Test
	public void strikeFrame_Check() {
		Ready ready = new Ready();
		State state = ready.bowl(10);
		assertTrue(state instanceof Strike);
		assertTrue(state.isEnd());
	}

	@Test
	public void spareFrame_Check() throws Exception {
		First first = new First(2);
		State state = first.bowl(8);
		assertTrue(state instanceof Spare);
		assertTrue(state.isEnd());
		assertThat(state.getFirstBowlScore(), is(2));
	}

	@Test
	public void seccondFrame_Check() throws Exception {
		First first = new First(2);
		State state = first.bowl(5);
		assertTrue(state instanceof Second);
		assertTrue(state.isEnd());
		assertThat(state.getFirstBowlScore(), is(2));
		assertThat(state.getSecondBowlScore(), is(5));

	}

}
