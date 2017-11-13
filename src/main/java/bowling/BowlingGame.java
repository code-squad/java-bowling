package bowling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.frame.Frame;
import bowling.frame.state.BowlingEnd;
import bowling.result.Result;
import bowling.user.User;
import bowling.view.BowlingFormView;

public class BowlingGame {
	private static final Logger log = LoggerFactory.getLogger(BowlingGame.class);

	public static void main(String[] args) {
		User user = User.create(BowlingFormView.inputName());
		int start = 1;
		Frame frame = Frame.createFrame(start);
		Frame next = frame.bowl(BowlingFormView.bowling(user.printName()));
		do {
			next = next.bowl(BowlingFormView.bowling(user.printName()));
			Result result = frame.result();
			log.debug(result.show(user.printName()));
		} while (!(next.getState() instanceof BowlingEnd));

		// 계산
		// for (int index = 0; index < endCondition; index++) {
		// totalScore += bowlingGame.calcutateScore(frames, index);
		// scores.add(Score.inputScore(totalScore));
		//
		// }

		// 프레임 결과 출력
		// for (int i = 0; i < scores.size(); i++) {
		// log.debug("{} 번째 값 : {}", i, scores.get(i));
		// }
	}

	// private int calcutateScore(int[] frames, int index) {
	// if (frames[index] == 10) {
	// int i = index;
	// int score = 0;
	// try {
	// score = frames[index] + frames[index + 1] + frames[index + 2];
	// } catch (ArrayIndexOutOfBoundsException e) {
	// return frames[i];
	// }
	// return score;
	// }
	// if (frames[index] + frames[index + 1] == 10) {
	// int i = index;
	// int score = 0;
	// try {
	// score = frames[index] + frames[index + 1] + frames[index + 2];
	// } catch (ArrayIndexOutOfBoundsException e) {
	// return frames[i];
	// }
	// return score;
	// }
	// return frames[index] + frames[index + 1];
	// }
}
