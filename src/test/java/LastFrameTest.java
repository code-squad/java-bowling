
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.domain.Game;
import bowling.domain.Pin;

import static org.hamcrest.CoreMatchers.*;

public class LastFrameTest {

	Game game;
	Pin score;

	@Before
	public void setUp() {
		game = Game.of();
		score = Pin.of();
	}

	@Test
	public void 마지막프레임_초구스트라이크_이구_삼구() {
		score.addScore(10);
		score.addScore(5);
		score.addScore(4);
		assertThat(score.checkPin(), is("X|5|4"));
	}

	@Test
	public void 마지막프레임_초구스트라이크_이구_삼구스페어() {
		score.addScore(10);
		score.addScore(5);
		score.addScore(5);
		assertThat(score.checkPin(), is("X|5|/"));
	}

	@Test
	public void 마지막프레임_초구이구삼구스트라이크() {
		score.addScore(10);
		score.addScore(10);
		score.addScore(10);
		assertThat(score.checkPin(), is("X|X|X"));
	}

	@Test
	public void 마지막프레임_초구_이구스페어_일반() {
		score.addScore(5);
		score.addScore(5);
		score.addScore(5);
		assertThat(score.checkPin(), is("5|/|5"));
	}

	@Test
	public void 마지막프레임_점수계산_스트라이크_스페어() {
		score.addScore(10);
		game.addFrame(1, score);
		score = Pin.of();
		score.addScore(10);
		score.addScore(5);
		score.addScore(5);
		game.addFrame(10, score);
		assertThat(game.getLastScore(), is(30));
	}

	@Test
	public void 마지막프레임_점수계산일반() {
		score.addScore(10);
		game.addFrame(1, score);
		score = Pin.of();
		score.addScore(4);
		score.addScore(5);
		game.addFrame(10, score);
		assertThat(game.getLastScore(), is(19));
	}

	@Test
	public void 마지막프레임_점수계산_스페어_일반() {
		score.addScore(10);
		game.addFrame(1, score);
		score = Pin.of();
		score.addScore(5);
		score.addScore(5);
		score.addScore(4);
		game.addFrame(10, score);
		assertThat(game.getLastScore(), is(24));
	}

	@Test
	public void 마지막프레임_점수계산_3연속스트라이크() {
		score.addScore(10);
		game.addFrame(1, score);
		score = Pin.of();
		score.addScore(10);
		score.addScore(10);
		score.addScore(10);
		game.addFrame(10, score);
		assertThat(game.getLastScore(), is(40));
	}

}
