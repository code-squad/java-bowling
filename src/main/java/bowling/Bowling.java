package bowling;

import bowling.player.Players;
import bowling.utils.Utils;
import bowling.view.BowlingFormView;

public class Bowling {
	public static void main(String[] args) {
		Players players = Utils.playerCreate(Utils.inputPlayerCount(BowlingFormView.inputPlayerCount()));
		
	}
}
