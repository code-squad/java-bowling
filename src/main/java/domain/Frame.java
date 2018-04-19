package domain;

import domain.status.CalculateStatus;

public abstract class Frame {

    private Scores scores;

    public boolean isFrameEnd() {
        return statusEnd();
    }

    public boolean statusEnd() {
        return scores.isEnd();
    }

    Frame() {
        this.scores = Scores.of();
    }

    public void trying(final int score) {
        if (!isValidScore(score)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        assign(score);
    }

    boolean isValidScore(final int score) {
        return isValidToTotalScore(score, 0);
    }

    public boolean isValidToTotalScore(int score, int compareIndex) {
        return scores.isValidScore(score, compareIndex);
    }

    public void assign(int score) {
        scores.assignStatus(score);
    }

    boolean isSpare() {
        return scores.isSpare();
    }

    boolean isStrike() {
        return scores.isStrike();
    }

    boolean isOpen() {
        return scores.isOpen();
    }

    private String toScoreString() {
        return scores.toScoreString();
    }

    public String spareString() {
        return scores.spareString();
    }

    String toFrameString() {
        if (isSpare()) return spareString();
        return toScoreString();
    }

    public void isGivenMessageFromPresentFrame(Frame frame) {
        scores.takeFromPresent(frame.scores);
    }

    public void isGivenMessageFromBeforeFrame(Frame beforeFrame) {
        scores.takeFromBefore(beforeFrame.scores);
    }

    public int getTotalScore() {
        return scores.getTotalScore();
    }

    public boolean isCalculationDo() {
        return scores.isDo();
    }

    public void changeCalculateStatusToDo() {
        scores.changeDo();
    }

    @Override
    public String toString() {
        return toFrameString();
    }

    public void changeCalculationStatusToNotYet() {
        scores.changeNotYet();
    }

    public CalculateStatus getCalculateStatus() {
        return scores.getCalculateStatus();
    }
}


