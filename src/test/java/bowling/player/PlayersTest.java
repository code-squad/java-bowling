package bowling.player;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import bowling.exception.BowlingGameException;
import bowling.utils.Utils;

public class PlayersTest {
	Players players;

	@Test
	public void 플레이어_생성() {
		Players players = Utils.playerCreate(Utils.inputPlayerCount(3));
		assertThat(players.size(), is(3));
	}

	@Test
	public void 플레이어_생성_예외발생_case_2() {
		players = Utils.playerCreate(Utils.inputPlayerCount(-9));
		assertThat(players.size(), is(0));
	}

}
