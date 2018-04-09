
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.domain.Game;

import static org.hamcrest.CoreMatchers.*;

public class NormalFrameTest {

	Game game;

	@Before
	public void setUp() {
		game = Game.of("lsc");
	}

	@Test
	public void 일반프레임_초구_스트라이크() {
		// 스트라이크 1프레임 초구
		game.addFrame(10, 1, 1);
		assertThat(game.getDownPin(1), is("X" + "  "));
	}

	@Test
	public void 일반프레임_초구_노스트라이크() {
		// 노스트라이크 1프레임 초구
		game.addFrame(5, 1, 1);
		assertThat(game.getDownPin(1), is("5| "));
	}

	@Test
	public void 일반프레임_2구_스페어() {
		// 노스트라이크 1프레임 초구
		game.addFrame(5, 1, 1);
		// 스페어 1프레임 2구
		game.addFrame(5, 1, 2);
		assertThat(game.getDownPin(1), is("5|/"));
	}

	@Test
	public void 일반프레임_2구_노스페어() {
		// 노스트라이크 1프레임 초구
		game.addFrame(5, 1, 1);
		// 노스페어 1프레임 2구
		game.addFrame(4, 1, 2);
		assertThat(game.getDownPin(1), is("5|4"));
	}

}
