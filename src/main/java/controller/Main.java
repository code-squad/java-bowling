package controller;

import java.util.Scanner;

import model.Bowling;
import view.InputView;
import view.ResultView;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String playerName = InputView.getPlayerName(sc);
		ResultView.printBlankTable(playerName);
		Bowling bowling = new Bowling();
		while (bowling.currentFrame.getFrameNum() < 11) {
			ResultView.printFrameNum(bowling.currentFrame.getFrameNum());
			int falledPin = InputView.getFalledPin(sc);
			bowling.bowl(falledPin);
			ResultView.printStatus(playerName, bowling.getFrames());
		}
		System.out.println("게임이 끝났습니다.");
	}

}
