package bowling.model;

import java.util.ArrayList;
import java.util.List;

import bowling.view.BowlingResultView;

public class BowlingManager {
	private List<Player> players;
	private int index;
	private int round;
	private boolean endGame;

	public BowlingManager() {
		players = new ArrayList<>();
		index = 0;
		round = 1;
		endGame = false;
	}

	public void initPlayer(String name) {
		players.add(new Player(name, FrameFactory.initFrames()));
	}

	public void showResult() {
		BowlingResultView.showResults(players);
	}

	public void inputKnockedPins(String knockedPins) {
		Player player = players.get(index);
		int temp = player.setScore(knockedPins);
		index += temp;
		adjustPlayer();
	}

	private void adjustPlayer() {
		if (index == players.size()) {
			index = 0;
			round++;
			exitGame();
		}
	}

	private void exitGame() {
		if (round == 11) {
			endGame = true;
		}
	}

	public boolean isEndGame() {
		return endGame;
	}
}