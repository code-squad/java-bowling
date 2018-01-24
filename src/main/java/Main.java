import model.BowlingGame;
import model.Player;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(InputView.inputName());
        BowlingGame bowlingGame = new BowlingGame(player);
        while (!bowlingGame.isLast()){
            bowlingGame.progressGame(InputView.inputNumberOfPins(bowlingGame.getCurrentFrameNumber()));
            OutputView.showCurrentStatus(bowlingGame);
        }
    }
}
