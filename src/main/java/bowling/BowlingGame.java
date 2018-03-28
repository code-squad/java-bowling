package bowling;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.InputScore;
import view.OutputScore;

public class BowlingGame {
	private static final Logger log = LoggerFactory.getLogger(BowlingGame.class);

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			String name = InputScore.bowlingGameStart(scan);
			Frame frame = new NormalFrame(1);

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
