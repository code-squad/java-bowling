
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
	public void 마지막프레임_초구스트라이크() {
		score.addScore(10);
		assertThat(score.checkLastScore(), is("X|"));
	}

	@Test
	public void 마지막프레임_초구스트라이크_이구() {
		score.addScore(10);
		score.addScore(5);
		assertThat(score.checkLastScore(), is("X|5"));
	}

	@Test
	public void 마지막프레임_초구스트라이크_이구_삼구() {
		score.addScore(10);
		score.addScore(5);
		score.addScore(4);
		assertThat(score.checkLastScore(), is("X|5|4"));
	}

	@Test
	public void 마지막프레임_초구스트라이크_이구_삼구스페어() {
		score.addScore(10);
		score.addScore(5);
		score.addScore(5);
		assertThat(score.checkLastScore(), is("X|5|/"));
	}

	@Test
	public void 마지막프레임_초구이구스트라이크() {
		score.addScore(10);
		score.addScore(10);
		assertThat(score.checkLastScore(), is("X|X"));
	}

	@Test
	public void 마지막프레임_초구이구삼구스트라이크() {
		score.addScore(10);
		score.addScore(10);
		score.addScore(10);
		assertThat(score.checkLastScore(), is("X|X|X"));
	}

	@Test
	public void 마지막프레임_초구_이구스트라이크() {
		score.addScore(5);
		score.addScore(10);
		assertThat(score.checkLastScore(), is("5|X"));
	}

	@Test
	public void 마지막프레임_초구_이구스페어() {
		score.addScore(5);
		score.addScore(5);
		assertThat(score.checkLastScore(), is("5|/"));
	}

	@Test
	public void 마지막프레임_초구_이구() {
		score.addScore(5);
		score.addScore(4);
		assertThat(score.checkLastScore(), is("5|4"));
	}

}
