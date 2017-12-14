package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.InvalidFalledPinInputException;
import Exception.InvalidFrameNumberException;
import model.Pin;
import model.Player;
import view.InputView;
import view.ResultView;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int playerNum = InputView.getNumOfPlayer(sc);
		List<Player> players = InputView.getPlayers(playerNum, sc);
		ResultView.printFirstLine();
		players.forEach(player -> ResultView.printBlankTable(player.getName()));
		Player thisTurnPlayer = player.decideTurn();
		ResultView.printTurn(player);
		int falledPin = InputView.getFalledPin(name, sc);
		
	}
	
	public static void main1(String[] args) {
		String playerName = InputView.getPlayerName(sc);
		ResultView.printBlankTable(playerName);
		play(playerName);
		System.out.println("게임이 끝났습니다.");
	}

	public static void play(String playerName) {
		try {
			try {
				ResultView.printFrameNum(bowling.currentFrame.getFrameNum());
				bowling.bowl(new Pin(InputView.getFalledPin(sc)));
			} catch (InvalidFrameNumberException e) {
				ResultView.printResults(playerName, bowling);
				System.out.println("프레임 개수는 최대 10개입니다.");
				return;
			}
			ResultView.printResults(playerName, bowling);
			play(playerName);
		} catch (InvalidFalledPinInputException e) {
			System.out.println("볼링 핀은 0이상 10이하여야 합니다. 다시 입력해 주세요.");
			play(playerName);
		}
	}
}
