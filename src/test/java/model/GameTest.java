package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	Game game;
	Pin pin, pin1, pin2;
	List<Player> players;

	@Before
	public void setUp() {
		List<String> names = new ArrayList<>();
		names.add("Chloe");
		names.add("Pobi");
		names.add("Crong");
		game = new Game(names);
		players = game.getPlayers();
		pin = new Pin(10);
		pin1 = new Pin(9);
		pin2 = new Pin(1);
	}

	@Test
	public void 플레이어_고르기() throws Exception {
		game.choose();
		assertEquals("Chloe", game.getCurrentPlayer().getName());
	}

	@Test
	public void player_순서_정하기_두번째플레이어출력1() {
		game.play(pin);
		assertEquals("Pobi", game.getCurrentPlayer().getName());
	}

	@Test
	public void player_순서_정하기_세번째플레이어출력_플레이어끝났을때() {
		game.play(pin);
		game.play(pin);
		assertEquals("Crong", game.getCurrentPlayer().getName());
	}

	@Test
	public void player_순서_정하기_두번째플레이어출력_플레이어안끝났을때() {
		game.play(pin);
		game.play(pin2);
		assertEquals("Pobi", game.getCurrentPlayer().getName());
	}

	@Test
	public void player_순서_정하기_순환두번째플레이어출력() {
		for (int i = 0; i < 4; i++) {
			game.play(pin);
		}
		Player p4 = game.getCurrentPlayer();
		assertEquals("Pobi", p4.getName());
	}

	@Test
	public void 현재차례_플레이어의_status_구하기1() throws Exception {
		game.play(pin);
		List<Status> status = game.getPlayerStatus(game.getPlayers().get(0));
		assertEquals("X", status.get(0).getStatus());
	}

	@Test
	public void 현재차례_플레이어의_status_구하기2() throws Exception {
		game.play(pin);
		List<Status> status1 = game.getPlayerStatus(game.getPlayers().get(0));
		assertEquals("X", status1.get(0).getStatus());
		assertEquals(1, status1.size());

		game.play(pin);
		List<Status> status2 = game.getPlayerStatus(game.getPlayers().get(0));
		assertEquals("X", status2.get(0).getStatus());
		assertEquals(1, status2.size());
	}

	@Test
	public void status_구하기() throws Exception {
		game.play(pin1);
		game.play(pin2);

		List<Status> status1 = game.getPlayerStatus(game.getPlayers().get(0));
		assertEquals("9|/", status1.get(0).getStatus());
		assertEquals(1, status1.size());

		game.play(pin);
		List<Status> status2 = game.getPlayerStatus(game.getPlayers().get(1));
		assertEquals("X", status2.get(0).getStatus());
		assertEquals(1, status2.size());
	}

	@Test
	public void 현재차례_플레이어의_score_구하기1() throws Exception {
		for (int i = 0; i < 7; i++) {
			game.play(pin);
		}
		List<String> score = game.getPlayerScore(game.getPlayers().get(0));
		assertEquals("30", score.get(0));
	}

}
