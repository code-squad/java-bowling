package bowling.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	Game game;
	@Before
	public void setup() {
		game = new Game(Arrays.asList("abc", "asd", "lkj"));
	}

	@Test
	public void 첫번째_사용자() {
		assertThat(game.presentPlayer().getName()).isEqualTo("abc");
	}
	
	@Test
	public void 두번째_사용자() {
		assertThat(game.play(1).play(1).presentPlayer().getName()).isEqualTo("asd");
	}
	
	@Test
	public void 세번째_사용자() {
		assertThat(game.play(1).play(1).play(1).play(1).play(1).presentPlayer().getName()).isEqualTo("lkj");
	}
	
	@Test
	public void 다음_프레임() {
		game.play(1).play(1).play(1).play(1).play(1).play(1);
		assertThat(game.presentPlayer().getName()).isEqualTo("abc");
		assertThat(game.play(1).getFrameNo()).isEqualTo(2);
		assertThat(game.getFrameNo()).isEqualTo(2);
	}
}
