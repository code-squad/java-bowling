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
	}

	@Test
	public void test_setFirstFrameTotal() {
		board.createFrame(1, 6);
		assertEquals(9, board.getScoreBoard().get(1).getGameTotalScore());
	}
	
}
