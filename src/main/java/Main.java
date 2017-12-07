
public class Main {
	public static void main(String[] args) {
		Frame frame = new Frame(Frame.makeWholeFrame());
		Player player = new Player(Input.getName(), Player.initScores());
		View.view(frame, player);
		for (int i = 0; i <= 10; i++) {
			Player.play(frame, player, i);
		}
	}
}
