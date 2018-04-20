package bowling.domain;

public class NormalFrame implements Frame {

    private Status status;
    private Score score;

    public NormalFrame(Status status) {
        this.status = status;
    }

    public void updateFrameStatus(int pin) {
        Ball ball = Ball.of(pin);
        status = makeFrame(ball);
    }

    public Status makeFrame(Ball ball) {
        if (status.isNew()) {
            return ofFirst(ball);
        }
        return ofSecond(ball);
    }

    public Status ofFirst(Ball ball) {
        if (ball.isTenPin()) {
            return Strike.of(ball, null);
        }
        return new InComplete(ball, null);
    }

    public Status ofSecond(Ball ball) {
        if (isSpare(ball)) {
            return Spare.of(status.getFirstBall(), ball);
        }
        return Miss.of(status.getFirstBall(), ball);
    }

    public boolean checkComplete() {
        return status.checkComplete();
    }

    public boolean isSpare(Ball second) {
        return status.getFirst() + second.getPin() == 10;
    }

    public void createScore(Frame frame) {
        score = status.getScore(frame.totalScore());
    }

    public void updateScore(Score updateScore) {
        score = updateScore;
    }

    public Score getScore() {
        return score;
    }

    public int totalScore(){
        return score.getScore();
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        return status.toString();
    }

    public static NormalFrame ofInComplete() {
        return new NormalFrame(InComplete.of(null, null));
    }
}
