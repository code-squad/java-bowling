public class Main {
	public static void main(String[] args) {
		
		int howManyPeople = Input.getHowManyPeople();
		Players players = new Players();
		players.makePlayers(howManyPeople);
		
		while (!players.isFinished()) {
			for (Player player : players.getPlayers()) {
				int pinsPerTry = Input.getPinsPerTry(player);
				player.play(pinsPerTry);
				View.showAll(players);					
			}			
		}
	}
}
