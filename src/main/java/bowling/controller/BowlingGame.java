package bowling.controller;

import bowling.model.Frame;
import bowling.model.Player;
import bowling.view.InputView;
import bowling.view.OutputView;

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
		}
	}

	private static String[] setScore(Frame head) {
		Frame temp = head;
		String[] scores = new String[10];
		while (temp != null) {
			scores[temp.getId() - 1] = temp.toString();
			temp = temp.next;
		}
		return scores;
	}
}
