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
		assertEquals(10,player.getFrame().size());
	}

	
	@Test
	public void 유저를_만들고_점수를_입력() {
		player.setScore("2|4");
		player.setScore("5|2");
		player.setScore("7|1");
		player.setScore("2|0");
		assertEquals(23,player.getScore());
		
	}
}
