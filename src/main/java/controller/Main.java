package controller;

import java.util.Scanner;

import model.Bowling;
import view.InputView;
import view.ResultView;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Bowling bowling = new Bowling();

	public static void main(String[] args) {
		String playerName = InputView.getPlayerName(sc);
		ResultView.printBlankTable(playerName);
		play(playerName);
		System.out.println("게임이 끝났습니다.");
	}
	
	public static void play(String playerName) {
		ResultView.printFrameNum(bowling.currentFrame.getFrameNum());
		InputView.getFalledPin();
		bowling.bowl(InputView.falledPin);
		ResultView.printStatus(playerName, bowling.getFrames());
		if(bowling.currentFrame.getFrameNum() >= 11) {
			return;
		}
		else {
			play(playerName);
		}
	}

}
