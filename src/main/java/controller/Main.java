package controller;

import java.util.Scanner;

import Exception.InvalidFalledPinInputException;
import Exception.InvalidFrameNumberException;
import model.Bowling;
import model.Pin;
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
		try {
			try {
			ResultView.printFrameNum(bowling.currentFrame.getFrameNum());
			bowling.bowl(new Pin(InputView.getFalledPin(sc)));
			ResultView.printStatus(playerName, bowling.getFrames());
			}catch(InvalidFrameNumberException e) {
				ResultView.printStatus(playerName, bowling.getFrames());
				System.out.println("프레임 개수는 최대 10개입니다.");
				return;
			}
			play(playerName);
		} catch (InvalidFalledPinInputException e) {
			System.out.println("볼링 핀은 0이상 10이하여야 합니다.");
			System.out.println("다시 입력해 주세요.");
			play(playerName);
		}
	}
}
