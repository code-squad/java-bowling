package jjak.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayersTest {
	Players players;

	@Before
	public void setup() {
		players = new Players();
	}
	
	@Test
	public void 이름을_입력받아_플레이어들을_만들어주자() {
		players.addPlayer("4b");
		players.addPlayer("hue");
		assertEquals(2, players.list.size());
	}
}
