package bowling;

import bowling.view.InputView;


/**
 * @author sangsik.kim
 */
public class Console {

    public static void main(String[] args) {
        GameResult gameResult = new GameResult(InputView.getName());

        for (int i = 1; i < 10; i++) {
            Frame normalFrame = new NormalFrame(i);
            while (!normalFrame.isFinish()) {
                normalFrame.bowl(InputView.getPins(i));
                gameResult.addScore(normalFrame.getScore());
                InputView.displayFrameResult(gameResult);
            }
        }
    }
}
