package Ladder;

import Ladder.player.Players;
import Ladder.result.Result;
import Ladder.view.RadderFormView;

public class LadderGame {
	public static void main(String[] args) {
		Players players = Players.create(RadderFormView.playersInput());
		Result result = new Result(players, RadderFormView.radderHeight());
		System.out.println(result.show().toString());
	}
}
