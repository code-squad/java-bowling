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

		while (current != null) {
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
			int id = head.getId() - 1;
			try {
				scores[id] = head.getScore();
				if (head.getId() > 1)
					scores[id] += scores[id - 1];

				scoresStr[id] = Integer.toString(scores[id]);
			} catch(Exception e) {
				scores[id] = null;
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
