package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {
		Player player = new Player("lhs");
		assertEquals("lhs", player.getName());
	}

	@Test
	public void 프레임_생성이_잘되는지_보자() {
		Player player = new Player("lhs");
		player.bowl(4);
		assertEquals(1, player.getNowNo());
		player.bowl(4);
		assertEquals(2, player.getNowNo());
	}

	@Test
	public void 누적_점수를_확인해_보자() {
		Player player = new Player("lhs");
		player.bowl(10);
		player.bowl(10);
		player.bowl(2);
		player.bowl(3);
		player.calculate();
		assertEquals("42", player.getScore());
	}

	@Test
	public void 스트라이크_열번의_경우_확인해_보자() {
		Player player = new Player("lhs");
		for (int i = 0; i < 12; i++) {
			player.bowl(10);
			player.calculate();
		}
		assertEquals("300", player.getScore());
	}
}
