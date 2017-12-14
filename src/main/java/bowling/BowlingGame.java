package bowling;

import java.util.Scanner;

import bowling.model.Game;
import bowling.print.InputView;
import bowling.print.ResultView;

public class BowlingGame {

	public static void main(String[] args) {
		BowlingGame game = new BowlingGame();
		InputView input = new InputView(new Scanner(System.in));
		ResultView print = new ResultView();
		game.play(input, print);
		input.endConsole();
	}
	
	public void play(InputView input, ResultView print) {
		Game game = new Game(input.getPlayers());
		while (!game.isEnd()) {
			game.play(input.getThrowedPin(game.getFrameNo()));
			print.board(game.createBoard());
		}
	}
}