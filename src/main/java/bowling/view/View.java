package bowling.view;

import java.util.stream.IntStream;

import bowling.domain.frame.FinalFrame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.score.Score;

import static bowling.domain.frame.Frame.FINAL_FRAME;
import static java.util.Optional.ofNullable;

public class View {
    private static GameView gameView;
    private static Input input;

    public View(GameView gameView, Input input) {
        this.gameView = gameView;
        this.input = input;
        initView();
    }

    public void rendering() {
        normalRendering();
        finalRendering();
    }
    private void initView() {
        pringBagicView(gameView.firstFrame());
    }

    private void normalRendering() {
        for(int i = 1; i < 10; i++) {
            NormalFrame normalFrame = NormalFrame.generate(Score.in(input.getScore(i)));
            pringBagicView(gameView.initEmptyFrames(gameView.reflectView(normalFrame), i));

            int finalIndex = i;
            ofNullable(normalFrame).filter(frame -> !frame.isEnd()).map(frame -> nextNormalFrame(finalIndex, frame));
        }
    }

    private void finalRendering() {
        FinalFrame finalFrame = FinalFrame.generate(Score.in(input.getScore(FINAL_FRAME)));
        //pringBagicView(gameView.initEmptyFrames(gameView.reflectScore(finalFrame), FINAL_FRAME));

        IntStream.range(0, 2).forEach(i -> ofNullable(finalFrame).filter(frame -> !frame.isEnd()).map(View::nextFinalFrame));
    }

    private static NormalFrame nextNormalFrame(int index, NormalFrame normalFrame) {
        normalFrame = normalFrame.nextRound(Score.in(input.getScore(index)));
        pringBagicView(gameView.initEmptyFrames(gameView.reflectView(normalFrame), index));
        return normalFrame;
    }

    private static FinalFrame nextFinalFrame(FinalFrame frame) {
        frame = frame.nextRound(Score.in(input.getScore(FINAL_FRAME)));
        pringBagicView(gameView.nextFinalScore(frame));
        return frame;
    }

    private static void pringBagicView(String resultLine) {
        Output.printLine(Output.topLine());
        Output.printLine(resultLine);
    }
}
