package bowling;

import java.util.Scanner;

import view.InputScore;
import view.OutputScore;

public class BowlingGame {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			String name = InputScore.bowlingGameStart(scan);
			Frame frame = new Frame();

			while (!frame.getCurrentFrame().isEndGame()) {
				frame.roll(InputScore.inputScore(scan, frame.getCurrentFrameNo()));
				OutputScore.printScoreboard(frame, name);
			}
			System.out.println("게임 종료");
			scan.close();
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}
}
