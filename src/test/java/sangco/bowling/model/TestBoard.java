package sangco.bowling.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sangco.bowling.model.state.NormalFrame;
import sangco.bowling.model.state.SpareFrame;
import sangco.bowling.model.state.StrikeFrame;

public class TestBoard {
	private Board board;
	
	@Before
	public void setup() {
		board = new Board();
	}
	
	@Test
	public void test_createFrame() {
		board.createFrame(1, 10);
		board.createFrame(2, 10);
		board.createFrame(3, 10);
		board.createFrame(4, 10);
		board.createFrame(5, 10);
		board.createFrame(6, 7);
		board.createFrame(7, 7);
		board.createFrame(8, 5);
		board.createFrame(9, 3);
		board.createFrame(10, 5);
		assertTrue(board.scoreBoard.get(1) instanceof StrikeFrame);
		assertTrue(board.scoreBoard.get(6) instanceof SpareFrame);
		assertTrue(board.scoreBoard.get(7) instanceof SpareFrame);
		assertTrue(board.scoreBoard.get(8) instanceof NormalFrame);
		assertTrue(board.scoreBoard.get(9) instanceof NormalFrame);
	}
	
	@Test
	public void test_NomalFrame_setGameTotalScore() {
		
		board.createFrame(1, 4);
		board.createFrame(2, 5);
		board.createFrame(3, 6);
		assertEquals(24, board.scoreBoard.get(3).getGameTotalScore());
	}
	
	@Test
	public void test_SpareFrame_setGameTotalScore() {
		board.createFrame(1, 4);
		board.createFrame(2, 5);
		board.createFrame(3, 6);
		board.createFrame(4, 7);
		board.createFrame(5, 6);
		assertEquals(49, board.scoreBoard.get(5).getGameTotalScore());
	}
	
	@Test
	public void test_StrikeFrame_setGameTotalScore() {
		board.createFrame(1, 4);
		board.createFrame(2, 5);
		board.createFrame(3, 6);
		board.createFrame(4, 7);
		board.createFrame(5, 6);
		board.createFrame(6, 10);
		board.createFrame(7, 10);
		board.createFrame(8, 5);
		assertEquals(100, board.scoreBoard.get(8).getGameTotalScore());
	}
	
	@Test
	public void test_StrikeFrame_setGameTotalScore_continueStrike() {
		board.createFrame(1, 10);
		board.createFrame(2, 10);
		board.createFrame(3, 10);
		board.createFrame(4, 10);
		board.createFrame(5, 10);
		board.createFrame(6, 10);
		board.createFrame(7, 10);
		board.createFrame(8, 10);
		board.createFrame(9, 10);
		assertEquals(210, board.scoreBoard.get(7).getGameTotalScore());
	}
	
	@Test
	public void test_LastFrame_setGameTotalScore() {
		board.createFrame(1, 10);
		board.createFrame(2, 10);
		board.createFrame(3, 10);
		board.createFrame(4, 10);
		board.createFrame(5, 10);
		board.createFrame(6, 10);
		board.createFrame(7, 10);
		board.createFrame(8, 10);
		board.createFrame(9, 10);
		board.createFrame(10, 10);
		assertEquals(279, board.scoreBoard.get(10).getGameTotalScore());
	}
	
}
