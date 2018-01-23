package bowling.controller;

import bowling.model.frame.Frame;
import bowling.model.Player;
import bowling.view.InputView;
import bowling.view.OutputView;

import java.util.Arrays;

public class BowlingGame {

	public static void main(String[] args) {
		Frame head = new Frame();
		Frame current = head;

		Player player = new Player(InputView.askPlayer());
		OutputView.printScoreView(player, setScore(head));

		while (current != null && current.getId() <= 10) {
			int score = InputView.askScore(current.getId());
			current = current.bowl(score);
			OutputView.printScoreView(player, setScore(head));
			OutputView.printTotalScoreView(setTotalScore(head));
		}
	}

	private static String[] setTotalScore(Frame head) {
		Integer[] scores = new Integer[10];
		String[] scoresStr = new String[10];

		while (head != null) {
			try {
				scores[head.getId() - 1] = head.getScore();
				if (head.getId() > 1)
					scores[head.getId() - 1] += scores[head.getId() - 2];

				scoresStr[head.getId() - 1] = Integer.toString(scores[head.getId() - 1]);
			} catch(Exception e) {
				scores[head.getId() - 1] = null;
			}
			head = head.next;
		}

		return scoresStr;
	}


	private static String[] setScore(Frame head) {
		Frame curr = head;
		String[] scores = new String[10];
		while (curr != null) {
			scores[curr.getId() - 1] = curr.toString();
			curr = curr.next;
		}
		return scores;
	}
}
