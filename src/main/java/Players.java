import java.util.ArrayList;
import java.util.List;

public class Players {
	private List<Player> players = new ArrayList<>();
	
	List<Player> getPlayers() {
		return players;
	}
	
	void makePlayers(int howManyPeople) {
		for (int i = 0; i < howManyPeople; i++) {
			String name = Input.getName();
			Player player = new Player(name);
			players.add(player);
		}
	}
	
	boolean isFinished() {
		if (players.get(players.size() - 1).isFinished()) {
			return true;
		}
		return false;
	}
	
	void playAll(Player player) {
		int frameNo = player.getCurrentFrameNo();
		while (frameNo == player.getCurrentFrameNo()) {
			int pinsPerTry = Input.getPinsPerTry(player);
			player.play(pinsPerTry);
			View.showAll(this);			
		}
	}
}
