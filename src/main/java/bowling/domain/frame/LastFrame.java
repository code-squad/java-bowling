package bowling.domain.frame;

import bowling.domain.score.Score;
import bowling.domain.status.NotPlayed;
import bowling.domain.status.Status;

public class LastFrame implements Frame {
    private Status status;
    private Score score;
    private Bonus bonus;

    public LastFrame() {
        this.status = new NotPlayed();
        this.score = new Score();
    }

    public void bowl(int pins) {
        //check status:
        //if ready -> update,
        if (status.isNotPlayed()) {
            status.bowl(pins);
            status.updateScore(score);
        }
        // incomplete -> update,
        if (status.isPlayedOnce()) {
            status.bowl(pins);
            status.updateScore(score);
        }
        // complete/spare/strike -> don't update and decrease hold count
        if (status.isAllPlayed() || status.isSpare() || status.isStrike()) {
            score.decreaseCountUntilCalculation();
        }
    }
}