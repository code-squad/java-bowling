package bowling.domain.frame;

import bowling.domain.score.Score;
import bowling.domain.status.Ready;
import bowling.domain.status.Status;

public class NormalFrame implements Frame {
    private Status status;
    private Score score;

    public NormalFrame() {
        this.status = new Ready();
        this.score = new Score();
    }

    public void bowl(int pins) {
        //check status:
        //if ready -> update,
        if (status.isReady()) {
            status.bowl(pins);
            status.updateScore(score);
        }
        // incomplete -> update,
        if (status.isIncomplete()) {
            status.bowl(pins);
            status.updateScore(score);
        }
        // complete/spare/strike -> don't update and decrease hold count
        if (status.isComplete() || status.isSpare() || status.isStrike()) {
            score.decreaseCountUntilCalculation();
        }
    }

    public int calculateFrameScore(Frame nextFrame) {
        if (status.isStrike() && nextFrame.status ) {

        }
        if (status.isSpare()) {

        }
    }

    public int calculateAdditionalScore() {

    }
}