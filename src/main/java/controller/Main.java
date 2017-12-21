package controller;

import java.util.List;
import java.util.Scanner;

import Exception.InvalidFalledPinInputException;
import model.Game;
import model.Pin;
import view.InputView;
import view.ResultView;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int playerNum = InputView.getNumOfPlayer(sc);
		List<String> playerNames = InputView.getPlayers(playerNum, sc);
		ResultView.printFirstLine();
		playerNames.forEach(player -> ResultView.printBlankTable(player));
		Game game = new Game(playerNames);
		// 반복
		play(game);
		System.out.println("게임이 끝났습니다.");
	}

	private static void play(Game game) {
		try {
			ResultView.printTurn(game);
			game.play(new Pin(InputView.getFalledPin(sc)));
			ResultView.printResults(game);
			if (game.findLastPlayer().isLastBowl()) {
				System.out.println("10프레임이 최대프레임개수입니다.");
				return;
			}
			play(game);
		} catch (InvalidFalledPinInputException e) {
			System.out.println("볼링 핀은 0이상 10이하여야 합니다. 다시 입력해 주세요.");
			play(game);
		}
	}
}
