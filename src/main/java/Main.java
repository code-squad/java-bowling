
public class Main {
	public static void main(String[] args) {
		
		String name = Input.getName();
		Player player = new Player(name);
		
		for (int i = 0; i < 10; i++) {
			Frame frame = new Frame();
			int pinsPerTry = Input.getPinsPerTry(i);
			player.play(i, frame.makePinsPerFrame(pinsPerTry));
			View.showResult(player);
			if (pinsPerTry != 10) {
				pinsPerTry = Input.getPinsPerTry(i);
				player.play(i, frame.makePinsPerFrame(pinsPerTry));
				View.showResult(player);
			}
		}
	}
}
