package bowling.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void 유저를_만들자() {
		Player player = new Player("lhs", FrameFactory.initFrames());
		assertEquals("lhs", player.getName());
		assertEquals(10,player.getFrame().size());
	}

}
