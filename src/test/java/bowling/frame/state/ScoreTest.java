package bowling.frame.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {
	@Test(expected = CannotCalculateException.class)
	public void getScore_UnReady() throws Exception {
		new Score(10, 2).getScore();
	}
	
	@Test
	public void getScore_XX9() {
		Score score = new Score(10, 2);
		score.bowl(10);
		score.bowl(9);
		assertEquals(29, score.getScore());
	}

	@Test
	public void getScore_X81() {
		Score score = new Score(10, 2);
		score.bowl(8);
		score.bowl(1);
		assertEquals(19, score.getScore());
	}
	
	@Test
	public void getScore_Spare8() throws Exception {
		Score score = new Score(10, 1);
		score.bowl(8);
		assertEquals(18, score.getScore());
	}
}
