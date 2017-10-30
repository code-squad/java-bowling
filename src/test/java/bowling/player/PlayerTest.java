package bowling.player;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import bowling.utils.Utils;

public class PlayerTest {

	@Test
	public void 플레이어들의_번호() {
		Players players = Utils.playerCreate(Utils.inputPlayerCount(2));
		List<Player> lists = players.getPlayers();
		for (int i = 0; i < players.size(); i++) {
			Player player = lists.get(i);
			assertThat(player.getNo(), is(i));
		}
	}

	@Test
	public void 사용자가_점수를_입력한다() throws Exception {
		Players players = Utils.playerCreate(Utils.inputPlayerCount(2));
		List<Player> playerList = players.getPlayers();
		Player player = playerList.get(0);
		assertThat(player.bowl(5), is(5));
	}

}
