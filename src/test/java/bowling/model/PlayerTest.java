package bowling.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player;

	@Before
	public void setup() {
		player = new Player("lhs", FrameFactory.initFrames());
	}

	@Test
	public void 유저를_만들자() {
		assertEquals("lhs", player.getName());
		assertEquals(10, player.getFrame().size());
	}

	@Test
	public void 유저를_만들고_점수를_입력() {
		player.setScore("2");
		player.setScore("4");
		player.calculateSumScore();
		assertEquals("6", player.getSumScore());
		player.setScore("5");
		player.setScore("2");
		player.calculateSumScore();
		assertEquals("13", player.getSumScore());
		player.setScore("7");
		player.setScore("1");
		player.calculateSumScore();
		assertEquals("21", player.getSumScore());
		player.setScore("2");
		player.setScore("0");
		player.calculateSumScore();
		assertEquals("23", player.getSumScore());
	}
}
