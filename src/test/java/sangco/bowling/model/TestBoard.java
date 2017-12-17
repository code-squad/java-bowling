package sangco.bowling.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBoard {
	private Board board;
	
	@Before
	public void setup() {
		board = new Board();
	}
	
	@Test
	public void test_createOtherFrame() {
		assertEquals(new SpareFrame() instanceof SpareFrame, board.createOtherFrame(7) instanceof SpareFrame);
	}
	
	@Test
	public void test_createFrame() {
		board.createFrame(1, 10);
		assertEquals(new StrikeFrame() instanceof StrikeFrame, board.getScoreBoard().get(1) instanceof StrikeFrame);
	}
	
	@Test
	public void test_scoreBoard_have_10Frame() {
		board.createFrame(1, 10);
		board.createFrame(2, 10);
		board.createFrame(3, 10);
		board.createFrame(4, 10);
		board.createFrame(5, 10);
		board.createFrame(6, 7);
		board.createFrame(7, 7);
		board.createFrame(8, 5);
		board.createFrame(9, 5);
		board.createFrame(10, 5);
		
		System.out.println(board.getScoreBoard().size());
		System.out.println(board.getScoreBoard().get(1) instanceof StrikeFrame);
		System.out.println(board.getScoreBoard().get(6) instanceof SpareFrame);
		System.out.println(board.getScoreBoard().get(8) instanceof NormalFrame);
	}
}
