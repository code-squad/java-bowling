package bowling.model;

import java.util.ArrayList;
import java.util.List;

import bowling.view.BowlingResultView;

public class BowlingManager {
	private List<Player> players;
	private int index;

	public BowlingManager() {
		players = new ArrayList<>();
		index = 0;
	}

	public void initPlayer(String name) {
		players.add(new Player(name, FrameFactory.initFrames()));
	}

	public void showResult() {
		BowlingResultView.showResults(players);
	}

	public void inputKnockedPins(String knockedPins) {
		if (index == players.size()) {
			index = 0;
			//여기에 총 몇 프레임 했는지 카운트 하는 변수 넣고 그게 10 혹은 11이 되면 while문에 false를 리턴하여 종료하게 하자
		}
		Player player = players.get(index);
		int temp = player.setScore(knockedPins);
		index += temp;
	}
}