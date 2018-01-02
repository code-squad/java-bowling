package bowling;

import java.util.ArrayList;

import org.eclipse.jetty.websocket.common.extensions.fragment.FragmentExtension;

public class BowlingGame {

	public static void main(String[] args) throws Exception {
		gameStart();
	}

	public static void gameStart() throws Exception {
		Frames frames = new Frames();
		String result = ResultView.basicPrint();
		Player player = new Player(InputView.inputName());
		while (frames.isGameEnd()) {
			Frame frame = new NormalFrame(new ArrayList<Integer>());
			if (frames.countFrame() == 10)
				frame = new FinalFrame(new ArrayList<Integer>());
			
			while (frame.isNotEnd()) {
				//미래의 프레임이 과거의 프레임 상태를 확인하고 score를 계산시켜준다
				int score = frame.validateAddScore(frames.countFrame());
				frame.addScore(score);
				frames.checkScore(frame);
				System.out.println("totalScore : " + frames.getTotalScore(frame));
				result += frame.getStatusResult();
				ResultView.printScore(result, player);
			}
			
			frames.addFrame(frame);
		}
	}

}
