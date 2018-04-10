
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.domain.Game;
import bowling.domain.Score;

import static org.hamcrest.CoreMatchers.*;

public class NormalFrameTest {

	Game game;
	Score score;

	@Before
	public void setUp() {
		game = Game.of();
		score = Score.of();
	}

	@Test
	public void 일반프레임_스트라이크() {
		score.addScore(10);
		game.addNormalFrame(1, score);
		assertThat(game.getDownPin(0), is("X" + "  "));
	}

	@Test
	public void 일반프레임_스페어() {
		score.addScore(5);
		score.addScore(5);
		game.addNormalFrame(1, score);
		assertThat(game.getDownPin(0), is("5|/"));
	}

	@Test
	public void 일반프레임_2번투구() {
		score.addScore(4);
		score.addScore(5);
		game.addNormalFrame(1, score);
		assertThat(game.getDownPin(0), is("4|5"));
	}

}
