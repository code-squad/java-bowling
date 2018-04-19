package bowling.domain;

public class NormalFrame implements Frame {

    private FrameStatus frameStatus;
    private Score score;

    public NormalFrame(FrameStatus frameStatus) {
        this.frameStatus = frameStatus;
    }

    public void updateFrameStatus(int pin) {
        Ball ball = Ball.of(pin);
        frameStatus = makeFrame(ball);
    }

    public FrameStatus makeFrame(Ball ball) {
        if (frameStatus.isNew()) {
            return ofFirst(ball);
        }
        return ofSecond(ball);
    }

    public FrameStatus ofFirst(Ball ball) {
        if (ball.isTenPin()) {
            return Strike.of(ball, null);
        }
        return new InComplete(ball, null);
    }

    public FrameStatus ofSecond(Ball ball) {
        if (isSpare(ball)) {
            return Spare.of(frameStatus.getFirstBall(), ball);
        }
        return Miss.of(frameStatus.getFirstBall(), ball);
    }

    public boolean checkComplete() {
        return frameStatus.checkComplete();
    }

    public boolean isSpare(Ball second) {
        return frameStatus.getFirst() + second.getPin() == 10;
    }

    public void createScore(NormalFrame frame) {
        score = frameStatus.getScore(frame.totalScore());
    }

    public void createScoreZero() {
        score = frameStatus.getScore(0);
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

    public FrameStatus getFrameStatus() {
        return frameStatus;
    }

    public int firstInFrame() {
        return frameStatus.getFirst();
    }

    public int secondInFrame() {
        return frameStatus.getSecond();
    }

    public String toString() {
        return frameStatus.toString();
    }

    public static NormalFrame ofInComplete() {
        return new NormalFrame(InComplete.of(null, null));
    }


//    public boolean checkComplete() {
//        if (first.isTenPin() || isTwiceBall()) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean checkLastFrameComplete() {
//        if (isTwiceBall()) {
//            return true;
//        }
//        return false;
//    }
//
//    public void checkSecondBallException(int pin) {
//        if (!isStrike() && firstInFrame() + pin > 10) {
//            throw new IllegalArgumentException("핀의 합이 10을 초과하였습니다.");
//        }
//    }
//
//    public boolean isStrike() {
//        return first.isTenPin();
//    }
//
//    public boolean isSpare(Ball second) {
//        return frameStatus.getFirst()+second.getPin()==10;
//    }
//
//    public boolean isNew() {
//        return first == null;
//    }
//
//    public boolean isTwiceBall() {
//        return second != null;
//    }
}
