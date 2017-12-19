package sangco.bowling.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTotalScore {
	private Board board;
	
	@Before
	public void setup() {
		board = new Board();
	}
	
	@Test
	public void test_setTotalScoreCase1() {
		board.createFrame(1, 10);
		board.createFrame(2, 10);
		board.createFrame(3, 10);
		
	}
}
