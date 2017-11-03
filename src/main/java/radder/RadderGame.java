package radder;

import radder.player.Players;
import radder.result.Result;
import radder.view.RadderFormView;

public class RadderGame {
	public static void main(String[] args) {
		Players players = Players.create(RadderFormView.playersInput());
		Result result = new Result(players, RadderFormView.radderHeight());
		System.out.println(result.show().toString());
	}
}
