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
	public void bowl() {
		Player player = new Player("lhs");
//		assertEquals("", player.bowl(10));
	}
}
