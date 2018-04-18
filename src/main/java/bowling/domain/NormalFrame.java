package bowling.domain;

public class NormalFrame implements Frame {
    private Status status;
    private Score score;
    private int countUntilCalculation;

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

}
/*
Score 객체는 전 스코어 + 현재 스코어만 가지면 된다?
 */