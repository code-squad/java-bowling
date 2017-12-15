package bowling;

public class Main {
	public static void main(String[] args) {
		String playerName = InputView.getName();
		Player player1 = new Player(playerName);
		Status player1Status = new Status(player1);
		
		while (player1Status.getFrame().getFrameNum() < 10) {
			Play.throwBall(player1Status);
			ResultView.printFormat();
			ResultView.printStatus(player1Status);
		}
//		for (int i = 0; i < 8; i++) {
//			Play.throwBall(player1Status);
//		}
	}
}
