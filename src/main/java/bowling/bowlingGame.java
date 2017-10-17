package bowling;

import java.util.Scanner;

import bowling.model.BowlingManager;
import bowling.view.BowlingFormView;

public class bowlingGame {
	public static void main(String[] args) {
		BowlingManager bm = new BowlingManager();
		Scanner scanner = new Scanner(System.in);
		int playerVolume = BowlingFormView.getNumbers(scanner);

		for (int i = 0; i < playerVolume; i++) {
			String name = BowlingFormView.inputName(scanner);
			bm.initPlayer(name);
		}
		while (true) {
			String KnockedPins = BowlingFormView.inputKnockedPins(scanner);
			bm.inputKnockedPins(KnockedPins);
			bm.showResult();
		}
	}
}
