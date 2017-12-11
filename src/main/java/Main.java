
public class Main {
	public static void main(String[] args) {
		
		String name = Input.getName();
		Player player = new Player(name);
		
		for (int i = 0; i < 10; i++) {
			Frame frame = new Frame();
			int pinsPerTry = Input.getPinsPerTry(i);
			start(player, i, frame, pinsPerTry);
			if (pinsPerTry != 10) {
				pinsPerTry = Input.getPinsPerTry(i);
				start(player, i, frame, pinsPerTry);
			}
		}
	}

	private static void start(Player player, int i, Frame frame, int pinsPerTry) {
		player.play(i, frame.makePinsPerFrame(pinsPerTry));
		View.showResult(player);
	}
}
