package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.frame.CannotCalculateException;

public class ScoreTest {
	@Test(expected = CannotCalculateException.class)
	public void getScore_UnReady() throws Exception {
		new Score(10, 2).getScore();
	}
	
	@Test
	public void getScore_XX9() {
		Score score = new Score(10, 2);
		assertEquals(29, score.bowl(10).bowl(9).getScore());
	}

	@Test
	public void getScore_X81() {
		Score score = new Score(10, 2);
		assertEquals(19, score.bowl(8).bowl(1).getScore());
	}
	
	@Test
	public void getScore_Spare8() throws Exception {
		Score score = new Score(10, 1);
		assertEquals(18, score.bowl(8).getScore());
	}
}
