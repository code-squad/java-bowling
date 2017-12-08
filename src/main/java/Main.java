
public class Main {
	public static void main(String[] args) {
		View view = new View(View.makeFullFrame());
		Player player = new Player(Input.getName(), Player.initScores());
		View.view(view, player);
		for (int i = 0; i <= 9; i++) {
			Player.play(view, player, i);
		}
	}
}
