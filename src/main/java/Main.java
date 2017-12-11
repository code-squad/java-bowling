
public class Main {
	public static void main(String[] args) {
		
		String name = Input.getName();
		Player player = new Player(name);
		
		while (player.isFinished()) {
			int pinsPerTry = Input.getPinsPerTry(player);
			player.play(pinsPerTry);
			View.showResult(player);
		}
	}
}
