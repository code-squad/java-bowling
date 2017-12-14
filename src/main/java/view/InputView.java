package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Player;

public class InputView {	
	public static int getNumOfPlayer(Scanner sc) {
		System.out.print("How many people?");
		return sc.nextInt();
	}

	public static List<Player> getPlayers(int playerNum, Scanner sc){
		List<Player> players = new ArrayList<>();
		for(int i=0; i < playerNum; i++) {
			System.out.print("플레이어 " + i + "의 이름은?(3 english letters):");
			players.add(new Player(sc.next()));
		}
		return players;
	}
	
	public static int getFalledPin(Scanner sc) {
		return sc.nextInt();
	}
}
