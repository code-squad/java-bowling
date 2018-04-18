
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.domain.Game;
import bowling.domain.Pin;

import static org.hamcrest.CoreMatchers.*;

public class NormalFrameTest {

	Game game;

	@Before
	public void setUp() {
		game = Game.of();
	}

	@Test
	public void 일반프레임_스트라이크() {
		game.addScore(10);
		game.addFrame(1);
		assertThat(game.getDownPin(0), is("X" + "  "));
	}

	@Test
	public void 일반프레임_스페어() {
		game.addScore(5);
		game.addScore(5);
		game.addFrame(1);
		assertThat(game.getDownPin(0), is("5|/"));
	}

	@Test
	public void 일반프레임_2번투구() {
		game.addScore(4);
		game.addScore(5);
		game.addFrame(1);
		assertThat(game.getDownPin(0), is("4|5"));
	}

	@Test
	public void 일반프레임_점수계산_연속스트라이크() {
		game.addScore(10);
		game.addFrame(1);
		assertThat(game.getLastScore(), is(10));
		game.addScore(10);
		assertThat(game.getLastScore(), is(20));
	}
	@Test
	public void 일반프레임_점수계산_스트라이크_스페어() {
		game.addScore(10);
		game.addFrame(1);
		assertThat(game.getLastScore(), is(10));
		game.addScore(5);
		game.addFrame(2);
		assertThat(game.getLastScore(), is(25));
		game.addScore(5);
		game.addFrame(3);
		assertThat(game.getLastScore(), is(45));
		game.addScore(4);
		assertThat(game.getLastScore(), is(69));
		
	}
	@Test
	public void 일반프레임_점수계산_스트라이크_일반() {
		game.addScore(10);
		game.addFrame(1);
		assertThat(game.getLastScore(), is(10));
		game.addScore(5);
		game.addScore(4);
		assertThat(game.getLastScore(), is(19));
	}

}
