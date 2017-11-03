package bowling.frame.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StateTest {

	@Test
	public void 두개를_쓰러트렸을때() {
		State state = new Ready().bowl(2);
		assertTrue(state instanceof First);
		assertFalse(state.isEnd());
		assertEquals("  2|   |", state.getChar());
	}

	@Test
	public void 두개_세개를_쓰러트렸을때() {
		State state = new Ready().bowl(2);
		state = state.bowl(3);
		assertTrue(state instanceof Second);
		assertEquals("  2|3  |", state.getChar());
	}

	@Test
	public void 스트라이크_일_떄() {
		State state = new Ready();
		state = state.bowl(10);
		assertTrue(state instanceof Strike);
		assertEquals("  X   |", state.getChar());

	}

	@Test
	public void 스페어_일_떄() {
		State state = new Ready().bowl(2);
		state = state.bowl(8);
		assertTrue(state instanceof Spare);
		assertEquals("  2|/  |", state.getChar());

	}

	@Test(expected = IllegalArgumentException.class)
	public void 스트라이크_이고_점수를입력했을때() {
		State state = new Ready().bowl(10);
		assertTrue(state.bowl(10) instanceof Spare);
	}

	@Test
	public void 마지막_프레임_두개를_쓰러트렸을때() {
		State state = new LastReady();
		assertTrue(state.bowl(2) instanceof LastFirst);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 마지막_프레임_두개_세개를_쓰러트리_이고_점수를입력했을때() {
		State state = new LastReady().bowl(2);
		state = state.bowl(3);
		state = state.bowl(3);
		assertTrue(state instanceof LastSecond);
	}

	@Test
	public void 마지막_프레임_두개_세개를_쓰러트렸을때() {
		State state = new LastReady().bowl(2);
		state = state.bowl(3);
		assertTrue(state instanceof LastSecond);
	}

	@Test
	public void 마지막_프레임_스페어() {
		State state = new LastReady().bowl(2);
		state = state.bowl(8);
		state = state.bowl(10);
		assertTrue(state instanceof LastEnd);
		assertEquals(" 2|8|10 |", state.getChar());
	}

	@Test
	public void 마지막_프레임_3연속_스트라이크() {
		State state = new LastReady().bowl(10);
		state = state.bowl(10);
		state = state.bowl(10);
		assertTrue(state instanceof LastEnd);
		assertEquals(" 10|10|10 |", state.getChar());
	}
}
