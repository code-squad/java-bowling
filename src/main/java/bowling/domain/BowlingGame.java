package bowling.domain;

import bowling.view.InputView;
import bowling.view.ResultView;

public class BowlingGame {

    public static void main(String[] args) {
        String name = InputView.getName();
        Frames frames = new Frames();

        while(!frames.isLast()){
            int score = InputView.getFrameScore(frames.size());
            frames.marking(score);
            ResultView.viewScore(name, frames.getResult());
        }
    }
}
