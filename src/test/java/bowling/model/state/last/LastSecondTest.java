package bowling.model.state.last;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.model.state.State;

public class LastSecondTest {

	@Test
	public void 스트라이크_스페어가_없어서_끝나는_두번째_State() {
		State second = new LastSecond(3, 5);
		assertTrue(second.isEnd());
	}

	@Test
	public void 세번째_상태_만들기() {
		State second = new LastSecond(4, 6);
		State state = second.bowl(5);
		assertTrue(state instanceof LastThird);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void 스트라이크_스페어가_아닌_상태서_새로운_값_추가하기() {
		State second = new LastSecond(4, 2);
		State state = second.bowl(5);
		assertTrue(state instanceof LastThird);
	}
	
	@Test
	public void getScoreTest() {
		State state = new LastSecond(3,6);
		assertEquals("3|6", state.getKnockedPins());
	}

}
