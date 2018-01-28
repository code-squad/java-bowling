package bowling.view;

import java.util.stream.IntStream;

import bowling.domain.Game;
import bowling.domain.frame.FinalFrame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.score.Score;

import static bowling.domain.frame.Frame.FINAL_FRAME;
import static java.util.Optional.ofNullable;

public class View {
    private static Game game;
    private static Input input;

    public View(Game game, Input input) {
        this.game = game;
        this.input = input;
        initView();
    }

    public void rendering() {
        normalRendering();
        finalRendering();
    }
    private void initView() {
        printView(game.createView(""));
    }

    private void normalRendering() {
        for(int i = 1; i < 10; i++) {
            NormalFrame normalFrame = NormalFrame.generate(Score.in(input.getScore(i)));
            printView(game.reflectView(normalFrame));

            int finalIndex = i;
            ofNullable(normalFrame).filter(frame -> !frame.isEnd()).map(frame -> nextNormalFrame(finalIndex, frame));
        }
    }

    private void finalRendering() {
        FinalFrame finalFrame = FinalFrame.generate(Score.in(input.getScore(FINAL_FRAME)));
        printView(game.reflectFinalView(finalFrame));

        IntStream.range(0, 2).forEach(i -> ofNullable(finalFrame).filter(frame -> !frame.isEnd()).map(View::nextFinalFrame));
    }

    private static NormalFrame nextNormalFrame(int index, NormalFrame normalFrame) {
        normalFrame = normalFrame.nextRound(Score.in(input.getScore(index)));
        printView(game.reflectView(normalFrame));
        return normalFrame;
    }

    private static FinalFrame nextFinalFrame(FinalFrame finalFrame) {
        finalFrame = finalFrame.nextRound(Score.in(input.getScore(FINAL_FRAME)));
        printView(game.reflectFinalView(finalFrame));
        return finalFrame;
    }

    private static void printView(String resultLine) {
        Output.printLine(Output.topLine());
        Output.printLine(resultLine);
    }
}
