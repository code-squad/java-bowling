package bowling;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import view.InputScore;
import view.OutputScore;

public class GameStart {
	private static final Logger log = LoggerFactory.getLogger(GameStart.class);

	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);
			InputScore.bowlingGameStart(scan);
			InputScore.inputScore(scan, 1);

			Frame frame = new NomalFrame(1);
			
			// 임시로 for문, 향후에 LastFrame 구현해서 처리
			for (int i = 0; i < 10; i++) {
				
			}
			

			// for문 10개 돌게
			// 그안에 for문 유저수 만큼
			// 그러면 돌아가면서 한 프레임 마다 실행 할 수 있다.

			scan.close();

		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}
}
