package sangco.bowling.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTotalScore {
	private Board board;
	private TotalScore totalScore;
	
	@Before
	public void setup() {
		board = new Board();
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
	}
	
	
	@Test
	public void test_scoreBoard_have_10Frame() {
		System.out.println(board.getScoreBoard().size());
		System.out.println(board.getScoreBoard().get(1) instanceof StrikeFrame);
		System.out.println(board.getScoreBoard().get(6) instanceof SpareFrame);
		System.out.println(board.getScoreBoard().get(8) instanceof NormalFrame);
	}
}
