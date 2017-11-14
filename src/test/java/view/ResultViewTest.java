package view;

import org.junit.Test;

import model.Game;

public class ResultViewTest {
	
	@Test
	public void resultViewTest() {
		ResultView resultView = new ResultView();
		resultView.currentResultView(new Game(10));
	}

}
