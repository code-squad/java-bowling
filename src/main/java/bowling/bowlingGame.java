package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bowling.model.FrameFactory;
import bowling.model.Player;
import bowling.view.BowlingFormView;
import bowling.view.BowlingResultView;

public class bowlingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int playerNumbers = BowlingFormView.getNumbers(scanner);

		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < playerNumbers; i++) {
			players.add(new Player(BowlingFormView.inputName(scanner), FrameFactory.initFrames()));
		}
		
		Player player = players.get(0);
		player.setScore("1|4");
		player.setScore("2|2");
		player.setScore("3|1");
		player.setScore("4|0");
		player.setScore("5|4");
		player.setScore("6|2");
		player.setScore("7|1");
		player.setScore("8|0");
		player.setScore("9|1");
		player.setScore("1|0");
		
		BowlingResultView.showResults(players);
	}
}
