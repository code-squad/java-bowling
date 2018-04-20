package bowling.domain;

public class LastFrame implements Frame {

    private Status status;
    private Ball third;
    private Score score;

    public LastFrame(Status status) {
        this.status = status;
    }

    public void updateFrameStatus(int pin) {
        if (!status.checkComplete()) {
            Ball ball = Ball.of(pin);
            status = makeFrame(ball);
            return;
        }
        playBonusBall(pin);
    }

    public void playBonusBall(int pin) {
        checkPinException(pin);
        third = Ball.of(pin);
    }

    public Status makeFrame(Ball ball) {
        if (status.isNew()) {
            return InComplete.of(ball, null);
        }
        return ofSecond(ball);
    }

    public Status ofSecond(Ball ball) {
        if (isStrike()) {
            return Strike.of(status.getFirstBall(), ball);
        }
        if (isSpare(ball)) {
            return Spare.of(status.getFirstBall(), ball);
        }
        return Miss.of(status.getFirstBall(), ball);
    }

    public boolean checkComplete() {
        if (isLastBall() || !isThird()) {
            return true;
        }
        return false;
    }

    public boolean isThird() {
        return third == null;
    }

    public boolean isLastBall() {
        return status.isLastBall();
    }

    public boolean isStrike() {
        return status.getFirst() == Ball.MAX_PIN;
    }

    public boolean isSpare(Ball second) {
        return status.getFirst() + second.getPin() == Ball.MAX_PIN;
    }

    public void createScore(Frame frame) {
        if (isLastBall()) {
            score = status.getScore(frame.totalScore());
            return;
        }
        if (!isThird()) {
            score = status.getScore(frame.totalScore() + third.getPin());
        }
    }

    public void updateScore(Score updateScore) {
        score = updateScore;
    }

    public Score getScore() {
        return score;
    }

    public int totalScore() {
        return score.getScore();
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        return status.lastFramePrint(third);
    }

    public void checkPinException(int pin) {            //마지막 프레임에 스트라이크면 그 이후의 핀 확인
        if (status.getCount() == 2 && status.getSecond() != 10 && status.getSecond() + pin > 10) {
            throw new IllegalArgumentException("핀의 숫자보다 더 많이 입력하셨습니다.");
        }
    }

    public static LastFrame ofInComplete() {
        return new LastFrame(InComplete.of(null, null));
    }
}
