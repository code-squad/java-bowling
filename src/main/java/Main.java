
public class Main {
	public static void main(String[] args) {
		Frame frame = new Frame(Frame.makeWholeFrame());
		Player player = new Player(Input.getName(), Player.initScores());
		View.view(frame, player);
		for (int i = 0; i <= 10; i++) {
			String firstScore = Input.getScore(i);
			player.makeFirstScore(i, firstScore);
			View.view(frame, player);				
			if (!firstScore.equals("10")) {
				String secondScore = Input.getScore(i);
				player.makeSecondScore(i, firstScore, secondScore);
				View.view(frame, player);
			}
		}
	}
}
