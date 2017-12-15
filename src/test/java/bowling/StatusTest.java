package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatusTest {
	//생성자 테스트.
	@Test
	public void makeStatusTest() {
		String playerName = "KOO";
		
		Player player1 = new Player(playerName);
		Status player1Status = new Status(player1);
		assertEquals("KOO", player1Status.getPlayer().getName());
		assertEquals(0, player1Status.getScore().getFrameScore());
		assertEquals(1, player1Status.getFrame().getFrameNum());
	}

}
