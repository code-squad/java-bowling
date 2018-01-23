package bowling;

import bowling.domain.BowlingUser;
import bowling.domain.frame.NormalFrame;
import bowling.domain.score.Score;
import bowling.view.GameView;
import bowling.view.Input;
import bowling.view.Output;

public class Main {

    public static void main(String[] args) {
        Input input = Input.generate(System.in);
        GameView gameView = GameView.generate(BowlingUser.registed(input.getName()));
        Output.printLine(Output.topLine());
        Output.printLine(gameView.firstFrame());

        for(int i = 1; i < 10; i++) {
            NormalFrame frame = NormalFrame.generate(Score.in(input.getScore(i)));
            Output.printLine(Output.topLine());
            Output.printLine(gameView.initEmptyFrames(gameView.firstReflectScore(frame), i));

            if(!frame.isEnd()) {
                frame = frame.nextRound(Score.in(input.getScore(i)));
                Output.printLine(Output.topLine());
                Output.printLine(gameView.initEmptyFrames(gameView.nextReflectScore(frame), i));
            }
        }

    }
}
