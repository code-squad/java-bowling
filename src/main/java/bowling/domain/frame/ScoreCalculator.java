package bowling.domain.frame;

import java.util.List;

public class ScoreCalculator {
    private final Frame currFrame;
    private final Frame nextFrame;
    private final Frame nextNextFrame;

    public ScoreCalculator(List<Frame> frames) {
        this.currFrame = frames.get(0);
        this.nextFrame = frames.get(1);
        this.nextNextFrame = frames.get(2);
    }

    public int calculateScore() {
        currFrame.getScore();
        nextFrame.calculateAdditionalScore(currFrame);

        if (currFrame.isStrike() && nextFrame.isStrike() && nex) {

        }
        if (currFrame.isSpare()) {

        }
    }


}
