package bowling.model.state.last;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.state.State;

public class LastReadyTest {

	@Test
	public void 일반적인_값을_줘서_다음_상태로_가자() {
		State ready = new LastReady();
		State state = ready.bowl(3);
		assertTrue(state instanceof LastFirst);
	}
	
	@Test
	public void 스트라이크_값을_줘서_다음_상태로_가자() {
		State ready = new LastReady();
		State state = ready.bowl(10);
		assertTrue(state instanceof LastFirst);
	}
	
	@Test
	public void getScoreTest() {
		State ready = new LastReady();
		assertEquals("  ", ready.getKnockedPins());
	}

}
