package domain;

import static domain.CalculateStatus.DONE;
import static domain.CalculateStatus.NOT_YET;

public abstract class Frame {

    private static final int MAX_ADDITIONAL_BONUS_SCORE = 20;
    private StatusChanger statusChanger;
    private ScoreManager scoreManager;
    private Scores scores;

    public boolean isFrameEnd() {
        return scores.isEnd();
    }

    Frame() {
        this.scores = Scores.of();
//        this.scoreManager = ScoreManager.of();
    }

    public void trying(final int score) {
        if (!isValidScore(score)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        scores.assignStatus(score);
//        addition(score);
//        this.statusChanger = initScoreCalculator();
    }

    void addition(final int score) {
        scoreManager.add(score);
    }

    public StatusChanger initScoreCalculator() {
        if (isBonusFrame()) {
            return StatusChanger.of(NOT_YET);
        }
        return StatusChanger.of(DONE);
    }

    boolean isTrySecond() {
        return scoreManager.isTrySecond();
    }

    boolean isSpare() {
        return scores.isSpare();
    }

//    boolean isSpare() {
//        return scoreManager.isSpare();
//    }

    boolean isStrike(int index) {
        return scoreManager.isStrike(index);
    }

    Score getFrameScore() {
        return scoreManager.getFrameScore();
    }

    boolean isValidScore(final int score) {
        return scores.isValidScore(score);
    }

//    boolean isValidScore(final int score) {
//        return scoreManager.isValidScore(score);
//    }

    boolean isValidScoreToTotalScore(final int score, final int compareIndex) {
        return scoreManager.isValidScoreToTotalScore(score, compareIndex);
    }

    private String toScoreString() {
        return scores.toScoreString();
    }

//    private String toScoreString() {
//        return scoreManager.toScoreString();
//    }

    private String spareString() {
        return scoreManager.spareString();
    }

    String toFrameString() {
//        if (isSpare()) return spareString();
        return toScoreString();
    }

//    String toFrameString() {
//        if (isSpare()) return spareString();
//        return toScoreString();
//    }

    public void assignCalculableState(Frame beforeFrame) {
        statusChanger = StatusChanger.of(this, beforeFrame);
    }

    public void isGivenMessageFromPresentFrame123123(Frame frame) {
        scores.takeFromPresent(frame.scores);
    }

    public void isGivenMessageFromPresentFrame(Frame frame) {
        if (statusChanger.isConditionBackward()) {
            sumAboutBonusOverCase(frame);
        }
        if (!isCalculationDone()) {
            statusChanger.changeCalculationStatusToNotYet();
        }
    }

    private void sumAboutBonusOverCase(Frame frame) {
        if (frame.scoreManager.isBonusOverThirty()) {
            sumScore(frame, () -> ScoreManager.totalScoreOf(MAX_ADDITIONAL_BONUS_SCORE));
            return;
        }
        sumScore(frame, () -> frame.scoreManager);
    }

    private void sumScore(Frame frame, ScoreStrategy strategy) {
        scoreManager.sum(strategy.scoreToSum());
        frame.statusChanger.changeCalculationStatusToNotYet();
        if (isCalculationNotComplete()) {
            statusChanger.changeCalculationStatusToNotYet();
        }
        if (frame.isBonusFrame() && !isBonusFrame() || (frame.isBonusFrame() && isBonusFrame()) || (isSpare() && !frame.isFrameEnd())) {
            frame.statusChanger.changeCalculationStatusToNotComplete();
        }
    }

    private interface ScoreStrategy {
        ScoreManager scoreToSum();
    }

    boolean isBonusFrame() {
        return isSpare() || isStrike(0);
    }

    public void isGivenMessageFromBeforeFrame(Frame beforeFrame) {
        beforeFrame.statusChanger.changeCalculationStatusToDone();
        if (statusChanger.isConditionForward(this, beforeFrame)) {
            scoreManager.sum(beforeFrame.scoreManager);
            statusChanger.changeCalculationStatusToDone();
        }
    }

    public int getTotalScore() {
        return scores.getTotalScore();
    }

//    public Score getTotalScore() {
//        return scoreManager.getTotalScore();
//    }

    public boolean isCalculationDo() {
        return scores.isDo();
    }

//    public boolean isCalculationDo() {
//        return statusChanger.isCalculationDo();
//    }

    public void changeCalculateStatusToDo() {
        scores.changeDo();
    }

//    public void changeCalculationStatusToDo() {
//        statusChanger.changeCalculationStatusToDo();
//    }

    public CalculateStatus getCalculateStatus() {
        return statusChanger.getCalculateStatus();
    }

    @Override
    public String toString() {
        return toFrameString();
    }

    public boolean isCalculationNotYet() {
        return statusChanger.isCalculationNotYet();
    }

    public boolean isCalculationDone() {
        return statusChanger.isCalculationDone();
    }

    public boolean isCalculationNotComplete() {
        return statusChanger.isCalculationNotComplete();
    }

    public void changeCalculationStatusToNotYet() {
        scores.changeNotYet();
    }

//    public void changeCalculationStatusToNotYet() {
//        statusChanger.changeCalculationStatusToNotYet();
//    }
}


