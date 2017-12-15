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
}
