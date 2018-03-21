package bowling;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import state.Finish;
import state.Strike;
import view.InputScore;
import view.OutputScore;

public class GameStart {
	private static final Logger log = LoggerFactory.getLogger(GameStart.class);

	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);
			String name = InputScore.bowlingGameStart(scan);
			Frame frame = new NomalFrame(1);

			// 임시로 for문, 향후에 LastFrame 구현해서 처리
			for (int i = 0; i < 10; i++) {
				int frameNo = frame.getCurrentFrameNo();

				if (frame.getCurrentFrame().getCurrentFrameState() instanceof Finish) {
					frameNo = frameNo + 1;
				}

				frame.InputBowl(new Pins(InputScore.inputScore(scan, frameNo)));
				OutputScore.printScoreboard(frame, name);
			}
			scan.close();
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}
}
