package bowling.domain;

public class LastFrame implements Frame{

    private FrameStatus frameStatus;
    private Ball third;
    private Score score;

    public LastFrame(FrameStatus frameStatus) {
        this.frameStatus = frameStatus;
    }

    public void updateFrameStatus(int pin) {
        Ball ball = Ball.of(pin);
        frameStatus = makeFrame(ball);
    }

    public FrameStatus makeFrame(Ball ball) {
        if (frameStatus.isNew()) {
            return InComplete.of(ball, null);
        }
        return ofSecond(ball);
    }

    public void playBonusBall(int pin) {
        checkPinException(pin);
        third = Ball.of(pin);
    }

    public boolean isThird() {
        return third == null;
    }

    public boolean isLastBall() {
        return frameStatus.isLastBall();
    }

    public int getThird() {
        return third.getPin();
    }

    public FrameStatus ofSecond(Ball ball) {
        if (isStrike()) {
            return Strike.of(frameStatus.getFirstBall(), ball);
        }
        if (isSpare(ball)) {
            return Spare.of(frameStatus.getFirstBall(), ball);
        }
        return Miss.of(frameStatus.getFirstBall(), ball);
    }

    public boolean checkComplete() {
        return frameStatus.checkComplete();
    }

    public boolean isStrike() {
        return frameStatus.getFirst() == 10;
    }

    public boolean isSpare(Ball second) {
        return frameStatus.getFirst() + second.getPin() == 10;
    }

    public void createScore(NormalFrame frame) {
        score = frameStatus.getScore(frame.totalScore());
    }

    public void createTwoScore(NormalFrame frame) {
        if (isLastBall()) {
            score = frameStatus.getScore(frame.totalScore());
        }
    }

    public void createThreeScore(NormalFrame frame, int pin) {
        score = frameStatus.getScore(frame.totalScore() + pin);
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

    public String toString() {
        return frameStatus.lastFramePrint(third);
    }

    public void checkPinException(int pin) {            //마지막 프레임에 스트라이크면 그 이후의 핀 확인
        if (frameStatus.getCount() == 2 && frameStatus.getSecond() != 10 && frameStatus.getSecond() + pin > 10) {
            throw new IllegalArgumentException("핀의 숫자보다 더 많이 입력하셨습니다.");
        }
    }
}
