package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bowling.model.FrameFactory;
import bowling.model.Player;
import bowling.view.BowlingFormView;

public class bowlingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int playerNumbers = BowlingFormView.getNumbers(scanner);
		
		List<Player> players = new ArrayList<Player>(); 
		for(int i =0; i < playerNumbers; i++) {
			players.add(new Player(BowlingFormView.inputName(scanner),FrameFactory.initFrames()));
		}
	}
}
