package bowling;

import bowling.domain.FrameManager;
import bowling.domain.Try;
import bowling.view.InputView;
import bowling.view.OutputView;

public class BowlingGame {
    public static void main(String[] args) {
        FrameManager frameManager = FrameManager.of();

        while ( !frameManager.isFinish()) {
            Try newTry = InputView.doGame();
            frameManager.shot(newTry);

            OutputView.show(frameManager.showHeader());
            OutputView.show(frameManager.showMessage());
            OutputView.show(frameManager.showScore());
        }

        OutputView.show("Good Game!");
    }
}
