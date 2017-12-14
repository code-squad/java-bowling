package bowling;

public class Main {
	public static void main(String[] args) {
		String playerName = InputView.getName();
		Player player1 = new Player(playerName);
		Score score1 = new Score();
		score1.updateScore(10, 1);
		ResultView.printFormat();
		ResultView.printStatus(player1.getName(), score1.getAccRec());;
	}
}
