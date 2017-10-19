package jjak;

import java.util.Scanner;

import jjak.model.Players;
import jjak.view.BowlingFormView;

public class BowlingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = BowlingFormView.insertPlayerCount(scanner);
		Players players = new Players();
		
		for(int i = 0; i < count; i++) {
			players.addPlayer(BowlingFormView.insertName(scanner));
		}
		
		int score = BowlingFormView.insertScore(scanner);
		System.out.println(count);
		System.out.println(score);
	}
}
