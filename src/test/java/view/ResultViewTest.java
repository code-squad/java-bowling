package view;

import org.junit.Test;

import model.Game;

public class ResultViewTest {
	
	@Test
	public void resultViewTest() {
		Game game = new Game(10);
		game.addPlayer("ABC");
		game.addPlayer("ABC");
		game.addPlayer("ABC");
		game.gameStart();
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(10);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		game.shot(2);
		
		ResultView resultView = new ResultView();
		resultView.currentResultView(game);
	}
}