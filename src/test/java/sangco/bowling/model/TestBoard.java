package sangco.bowling.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sangco.bowling.model.state.Spare;
import sangco.bowling.model.state.Strike;

public class TestBoard {
	private Board board;

	@Before
	public void setup() {
		board = new Board();
	}

	//@Test
	public void test_createFrame() {
		board.createFrame(5);
		board.createFrame(4);

		board.createFrame(5);
		board.createFrame(4);
		
		board.createFrame(6);
		board.createFrame(4);
		
		board.createFrame(6);
		board.createFrame(4);
		
		board.createFrame(6);
		board.createFrame(4);

		board.createFrame(10);

		board.createFrame(10);
		
		board.createFrame(10);
		
		board.createFrame(6);
		board.createFrame(4);

		board.createFrame(6);
		board.createFrame(4);
//		board.createFrame(4);
		
		// 10개 생성 되었는지
		assertEquals(10, board.scoreBoard.size());
		
		// 마지막 Frame은 LastFrame이 생성 되었는가
		assertTrue(board.getEachFrame(9) instanceof LastFrame);
//		assertTrue(board.getEachFrame(8) instanceof LastFrame);
		
		// Spare의 경우에 BowlingState가 State가 생성 되었는지
		assertTrue(board.getEachFrameState(3) instanceof Spare);
		assertTrue(board.getEachFrameState(4) instanceof Spare);

		// Strike의 경우에 BowlingState가 Strike가 생성 되었는지
		assertTrue(board.getEachFrameState(5) instanceof Strike);
		assertTrue(board.getEachFrameState(6) instanceof Strike);
		assertTrue(board.getEachFrameState(7) instanceof Strike);

		// 각각의 Frame이 NextFrame을 가지고 있는지
		assertTrue(board.getEachFrameNextFrame(0) != null);
		assertTrue(board.getEachFrameNextFrame(1) != null);
		assertTrue(board.getEachFrameNextFrame(2) != null);
		assertTrue(board.getEachFrameNextFrame(3) != null);
		assertTrue(board.getEachFrameNextFrame(4) != null);
		assertTrue(board.getEachFrameNextFrame(5) != null);
		assertTrue(board.getEachFrameNextFrame(6) != null);
		assertTrue(board.getEachFrameNextFrame(7) != null);
		assertTrue(board.getEachFrameNextFrame(8) != null);
		
		// LastFrame이 세번 던졌는지
//		assertEquals(3, ((LastFrame) board.scoreBoard.get(9)).getHowManyTimes());
		assertEquals(2, ((LastFrame) board.scoreBoard.get(9)).getHowManyTimes());
	}
	
	@Test
	public void test_checkTotalScore_nomalFrame() {
		board.createFrame(4);
		board.createFrame(4);

		board.createFrame(4);
		board.createFrame(4);
		
		board.createFrame(4);
		board.createFrame(4);
		
		board.createFrame(4);
		board.createFrame(4);
		
		assertEquals(32,board.getTotalScore());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @Test public void test_createFrame() { board.createFrame(1, 10);
	 * board.createFrame(2, 10); board.createFrame(3, 10); board.createFrame(4, 10);
	 * board.createFrame(5, 10); board.createFrame(6, 7); board.createFrame(7, 7);
	 * board.createFrame(8, 5); board.createFrame(9, 3); board.createFrame(10, 5);
	 * assertTrue(board.scoreBoard.get(1) instanceof StrikeFrame);
	 * assertTrue(board.scoreBoard.get(6) instanceof SpareFrame);
	 * assertTrue(board.scoreBoard.get(7) instanceof SpareFrame);
	 * assertTrue(board.scoreBoard.get(8) instanceof NormalFrame);
	 * assertTrue(board.scoreBoard.get(9) instanceof NormalFrame); }
	 * 
	 * @Test public void test_NomalFrame_setGameTotalScore() {
	 * 
	 * board.createFrame(1, 4); board.createFrame(2, 5); board.createFrame(3, 6);
	 * assertEquals(24, board.scoreBoard.get(3).getGameTotalScore()); }
	 * 
	 * @Test public void test_SpareFrame_setGameTotalScore() { board.createFrame(1,
	 * 4); board.createFrame(2, 5); board.createFrame(3, 6); board.createFrame(4,
	 * 7); board.createFrame(5, 6); assertEquals(49,
	 * board.scoreBoard.get(5).getGameTotalScore()); }
	 * 
	 * @Test public void test_StrikeFrame_setGameTotalScore() { board.createFrame(1,
	 * 4); board.createFrame(2, 5); board.createFrame(3, 6); board.createFrame(4,
	 * 7); board.createFrame(5, 6); board.createFrame(6, 10); board.createFrame(7,
	 * 10); board.createFrame(8, 5); assertEquals(100,
	 * board.scoreBoard.get(8).getGameTotalScore()); }
	 * 
	 * @Test public void test_StrikeFrame_setGameTotalScore_continueStrike() {
	 * board.createFrame(1, 10); board.createFrame(2, 10); board.createFrame(3, 10);
	 * board.createFrame(4, 10); board.createFrame(5, 10); board.createFrame(6, 10);
	 * board.createFrame(7, 10); board.createFrame(8, 10); board.createFrame(9, 10);
	 * assertEquals(210, board.scoreBoard.get(7).getGameTotalScore()); }
	 * 
	 * @Test public void test_LastFrame_setGameTotalScore() { board.createFrame(1,
	 * 10); board.createFrame(2, 10); board.createFrame(3, 10); board.createFrame(4,
	 * 10); board.createFrame(5, 10); board.createFrame(6, 10); board.createFrame(7,
	 * 10); board.createFrame(8, 10); board.createFrame(9, 10);
	 * board.createFrame(10, 10); assertEquals(279,
	 * board.scoreBoard.get(10).getGameTotalScore()); }
	 */
}
