package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void gameTest() {
		Game game = new Game(10);
		game.addPlayer("ABC");
		game.addPlayer("SHC");
		
		game.gameStart();

		game.shot(5);
		game.shot(4);
		game.shot(6);
		game.shot(4);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(5);
		game.shot(6);
		game.shot(4);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(3);
		game.shot(2);
		game.shot(10);
		game.shot(5);
		game.shot(5);
		assertEquals(192, game.getTotalScore(0));
		assertEquals(231, game.getTotalScore(1));
	}

}
