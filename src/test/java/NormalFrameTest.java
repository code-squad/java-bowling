
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.domain.Game;
import bowling.domain.Pin;

import static org.hamcrest.CoreMatchers.*;

public class NormalFrameTest {

	Game game;
	Pin score;

	@Before
	public void setUp() {
		game = Game.of();
		score = Pin.of();
	}

	@Test
	public void 일반프레임_스트라이크() {
		score.addScore(10);
		game.addFrame(1, score);
		assertThat(game.getDownPin(0), is("X" + "  "));
	}

	@Test
	public void 일반프레임_스페어() {
		score.addScore(5);
		score.addScore(5);
		game.addFrame(1, score);
		assertThat(game.getDownPin(0), is("5|/"));
	}

	@Test
	public void 일반프레임_2번투구() {
		score.addScore(4);
		score.addScore(5);
		game.addFrame(1, score);
		assertThat(game.getDownPin(0), is("4|5"));
	}

	@Test
	public void 일반프레임_점수계산_연속스트라이크() {
		score.addScore(10);
		game.addFrame(1, score);
		assertThat(game.getLastScore(), is(10));
		score.addScore(10);
		game.addFrame(2, score);
		assertThat(game.getLastScore(), is(30));
		score.addScore(10);
		game.addFrame(3, score);
		assertThat(game.getLastScore(), is(60));
	}
	@Test
	public void 일반프레임_점수계산_스트라이크_스페어() {
		score.addScore(10);
		game.addFrame(1, score);
		assertThat(game.getLastScore(), is(10));
		score.addScore(5);
		game.addFrame(2, score);
		assertThat(game.getLastScore(), is(25));
		score.addScore(5);
		game.addFrame(3, score);
		assertThat(game.getLastScore(), is(45));
		score.addScore(4);
		game.addFrame(4, score);
		assertThat(game.getLastScore(), is(69));
		
	}
	@Test
	public void 일반프레임_점수계산_스트라이크_일반() {
		score.addScore(10);
		game.addFrame(1, score);
		assertThat(game.getLastScore(), is(10));
		score.addScore(5);
		game.addFrame(2, score);
		assertThat(game.getLastScore(), is(25));
		score.addScore(4);
		game.addFrame(3, score);
		assertThat(game.getLastScore(), is(44));
	}

}
