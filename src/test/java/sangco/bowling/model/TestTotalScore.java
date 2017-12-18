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

/*	@Test
	public void test_setPrePreFrame() {
		board.createFrame(1, 10);
		board.createFrame(2, 10);
		board.createFrame(3, 6);
		assertEquals(26, board.getScoreBoard().get(1).getGameTotalScore());
	}
	
	@Test
	public void setPreFrame() {
		board.createFrame(1, 5);
		//하나가 nomal 일때를 아직 구현 안해서 26으로 넣었음.
		board.createFrame(2, 10);
		board.createFrame(3, 10);
		board.createFrame(4, 6);
		assertEquals(26, board.getScoreBoard().get(2).getGameTotalScore());
	}*/
}
