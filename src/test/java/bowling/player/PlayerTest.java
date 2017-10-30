package bowling.player;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bowling.frame.Frame;
import bowling.state.End;
import bowling.state.Running;

public class PlayerTest {

	@Test
	public void 플레이어_상태() {
		Player player = new Player("wsh");
		Frame frame = player.getFrame();
		assertTrue(frame.getState() instanceof Running);
	}

	@Test
	public void 사용자가_점수를_입력한다() throws Exception {
		Player player = new Player("wsh");
		Frame frame = player.getFrame();
		player.bowl(5);
		assertTrue(frame.getState() instanceof Running);
		player.bowl(5);
		assertTrue(frame.getState() instanceof End);
	}

}
