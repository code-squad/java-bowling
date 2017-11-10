package bowling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.view.BowlingFormView;

public class BowlingGame {
	private static final Logger log = LoggerFactory.getLogger(BowlingGame.class);

	public static void main(String[] args) {
		BowlingGame bowlingGame = new BowlingGame();
		String user = BowlingFormView.inputName();
		int[] frames = new int[23];
		int[] scores = new int[10];
		int endCondition = 10;
		int totalScore = 0;
		int count = 0;

		// 입력
		for (int i = 0; i != endCondition;) {
			int score = 0;
			frames[i] = score = BowlingFormView.inputScore(user);
			count++;
			if (score == 10) {
				count = 2;
			}
			if (count == 2) {
				count = 0;
				i++;
			}
		}

		// 계산
		for (int index = 0; index < endCondition; index++) {
			totalScore += bowlingGame.calcutateScore(frames, index);
			scores[index] = totalScore;

		}

		// 프레임 출력
		for (int index : frames) {
			log.debug("{} 번째 값 : {}", index, frames[index]);
		}

		// 프레임 결과 출력
		for (int i = 0; i < scores.length; i++) {
			log.debug("{} 번째 값 : {}", i, scores[i]);
		}
	}

	private int calcutateScore(int[] frames, int index) {
		if (frames[index] == 10) {
			int i = index;
			int score = 0;
			try {
				score = frames[index] + frames[index + 1] + frames[index + 2];
			} catch (ArrayIndexOutOfBoundsException e) {
				return frames[i];
			}
			return score;
		}
		if (frames[index] + frames[index + 1] == 10) {
			int i = index;
			int score = 0;
			try {
				score = frames[index] + frames[index + 1] + frames[index + 2];
			} catch (ArrayIndexOutOfBoundsException e) {
				return frames[i];
			}
			return score;
		}
		return frames[index] + frames[index + 1];
	}
}
