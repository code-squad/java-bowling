package bowling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.frame.Frame;
import bowling.user.User;
import bowling.view.BowlingFormView;

public class BowlingGame {
	private static final Logger log = LoggerFactory.getLogger(BowlingGame.class);

	public static void main(String[] args) {
		User user = User.create(BowlingFormView.inputName());
		// List<Frame> frames = new ArrayList<>();
		int start = 1;
		int end = 10;
		Frame frame = Frame.createFrame(start);

		// 입력
		while (end != 0) {
		}

		// for (int i = 0; i != endCondition;) {
		// int score = BowlingFormView.inputScore(user.printName());
		// frames[i] = score;
		// count++;
		// if (score == 10) {
		// count = 2;
		// }
		// if (count == 2) {
		// count = 0;
		// i++;
		// }
		// }

		// 계산
		// for (int index = 0; index < endCondition; index++) {
		// totalScore += bowlingGame.calcutateScore(frames, index);
		// scores.add(Score.inputScore(totalScore));
		//
		// }

		// 프레임 출력
		// for (int index : frames) {
		// log.debug("{} 번째 값 : {}", index, frames[index]);
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
