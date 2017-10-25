package bowling;

import java.util.Scanner;

import bowling.model.Players;
import bowling.view.BowlingFormView;
import bowling.view.BowlingResultView;

public class BowlingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numbers = BowlingFormView.inputNumbers(scanner);
		Players players = new Players();

		String name;
		for (int i = 0; i < numbers; i++) {
			name = BowlingFormView.inputName(scanner);
			players.add(name);
		}
		int knockedPins;
		while (!players.isEnd()) {
			knockedPins = BowlingFormView.inputBowl(scanner);
			players.bowl(knockedPins);
			BowlingResultView.showResult(players);
		}
		scanner.close();
	}
}
