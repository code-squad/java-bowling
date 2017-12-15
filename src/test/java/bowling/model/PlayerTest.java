package bowling.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player player;
	
	@Before
	public void setup() {
		player = new Player("abc");
		player.play(2);
	}
	
	@Test
	public void 프레임1() {
		assertThat(player.getFrameNo()).isEqualTo(1);
	}

	@Test
	public void 스트라이크_다음프레임() {
		player = new Player("pjs");
		player.play(10);
		player.play(1);
		assertThat(player.getFrameNo()).isEqualTo(2);
	}
	
	@Test
	public void 프레임2() {
		player.play(2);
		player.play(3);
		assertThat(player.getFrameNo()).isEqualTo(2);
	}
}
