package view;

import java.util.Scanner;

import model.Game;

public class InputView {
	private Scanner scan;

	public Game newGame() {
		scan = new Scanner(System.in);
		System.out.println("How many frame?");
		int frameNum = scan.nextInt();
		scan.close();
		return new Game(frameNum);
	}

	public Game createNumPlayer(Game game) {
		scan = new Scanner(System.in);
		System.out.print("How many people?");
		int numPlayer = scan.nextInt();
		for (int i = 0; i < numPlayer; i++) {
			System.out.println("플레이어 1의 이름은?(3 english letters):");
			game.addPlayer(scan.next());
		}
		game.gameStart();
		scan.close();
		return game;
	}

	public Game inputScore(Game game) {
		System.out.println(game.getCurrentPlayerName() + "'s turn : ");
		game.shot(scan.nextInt());
		scan.close();
		return game;
	}
}
