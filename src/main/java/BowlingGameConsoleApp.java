import domain.BowlingGame;
import domain.frame.Frame;
import domain.frame.NormalFrame;
import view.InputView;
import view.OutputView;

public class BowlingGameConsoleApp {
	private static BowlingGame bowlingGame;
	
	public static void main(String[] args) {
		bowlingGame = new BowlingGame(InputView.showGetPlayerNameView());
		do {
			bowlingGame.play(InputView.showGetPinCountView(bowlingGame.getNextFrameNumber()));
			OutputView.showStatusBoardView(bowlingGame);
		} while(bowlingGame.canPlay());
	}
}
