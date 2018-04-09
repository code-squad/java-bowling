
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.domain.Game;

import static org.hamcrest.CoreMatchers.*;

public class LastFrameTest {

	Game game;

	@Before
	public void setUp() {
		game = Game.of("lsc");
	}

	@Test
	public void 마지막프레임_초구_스트라이크() {
		// 스트라이크 10프레임 초구
		game.addFrame(10, 10, 1);
		assertThat(game.getDownPin(10), is("X||"));
	}

	@Test
	public void 마지막프레임_초구_노스트라이크() {
		// 5핀 10프레임 초구
		game.addFrame(5, 10, 1);
		assertThat(game.getDownPin(10), is("5|" + " "));
	}

	@Test
	public void 마지막프레임_2구_스페어() {
		// 4핀 10프레임 1구
		game.addFrame(4, 10, 1);
		// 스페어 10프레임 2구
		game.addFrame(6, 10, 2);
		assertThat(game.getDownPin(10), is("4|/|"));
	}

	@Test
	public void 마지막프레임_2구_노스페어() {
		// 4핀 10프레임 1구
		game.addFrame(4, 10, 1);
		// 5핀 10프레임 2구
		game.addFrame(5, 10, 2);
		assertThat(game.getDownPin(10), is("4|5"));
	}

	@Test
	public void 마지막프레임_스트라이크_3구() {
		// 스트라이크 10프레임 1구
		game.addFrame(10, 10, 1);
		// 5핀 10프레임 3구
		game.addFrame(5, 10, 2);
		assertThat(game.getDownPin(10), is("X||5"));
	}

	@Test
	public void 마지막프레임_스페어_3구() {
		// 5핀 10프레임 1구
		game.addFrame(5, 10, 1);
		// 스페어 10프레임 2구
		game.addFrame(5, 10, 2);
		// 5핀 10프레임 3구
		game.addFrame(5, 10, 3);
		assertThat(game.getDownPin(10), is("5|/|5"));
	}

}
