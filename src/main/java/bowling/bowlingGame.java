package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bowling.model.BowlingManager;
import bowling.model.FrameFactory;
import bowling.model.Player;
import bowling.view.BowlingFormView;
import bowling.view.BowlingResultView;

public class bowlingGame {
	public static void main(String[] args) {
		BowlingManager bm = new BowlingManager();
		Scanner scanner = new Scanner(System.in);
		int playerVolume = BowlingFormView.getNumbers(scanner);

		for (int i = 0; i < playerVolume; i++) {
			String name = BowlingFormView.inputName(scanner);
			bm.initPlayer(name);
		}
	}
}
