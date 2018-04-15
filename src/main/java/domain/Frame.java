package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static domain.CalculateStatus.DO;
import static domain.CalculateStatus.DONE;
import static domain.CalculateStatus.DONOT;
import static domain.CalculationDirection.LEFT;
import static domain.CalculationDirection.RIGHT;
import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public abstract class Frame {

    private Score frameScore;
    private Score totalScore;
    private List<Score> scores;
    private ScoreCalculator scoreCalculator;
//    private CalculateStatus calculateStatus;
//    private CalculationDirection calculationDirection = RIGHT;

    public abstract boolean isFrameEnd();

    Frame() {
        this.scores = new ArrayList<>();
        this.frameScore = Score.of();
        this.totalScore = Score.of();
    }

    public void trying(final int score) {
        if (!isValidScore(score)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        addition(score);
        this.scoreCalculator = initScoreCalculator();
    }

    protected abstract ScoreCalculator initScoreCalculator();

    void addition(final int score) {
        this.scores.add(Score.of(score));
        this.frameScore.sum(Score.of(score));
        this.totalScore.sum(Score.of(score));
    }

    boolean isTrySecond() {
        return scores.size() == 2;
    }

    boolean isSpare() {
        return frameScore.isTen() && isTrySecond();
    }

    boolean isFirstStrike() {
        return scores.get(0).isTen();
    }

    Score getFrameScore() {
        return frameScore;
    }

    boolean isValidScore(final int score) {
        return isValidScoreToTotalScore(score);
    }

    boolean isValidScoreToTotalScore(final int score) {
        return frameScore.isValidAdditionScore(score);
    }

    private String toScoreString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining(FRAMEBAR.toString()));
    }

    private String spareString() {
        return scores.get(0).toString() + FRAMEBAR + SPARE;
    }

    String toFrameString() {
        if (isSpare()) return spareString();
        return toScoreString();
    }

//    private boolean changeStatus(Frame beforeFrame) {
//        if (beforeFrame.isBonus())
//            return StatusChanger.beforeFrameDoNotCase(beforeFrame, this);
//        return StatusChanger.beforeFrameDoCase(this);
//    }

    public void assignCalculableState(Frame beforeFrame) {
        scoreCalculator = ScoreCalculator.of(this, beforeFrame);
//        calculateStatus = CalculateStatus.of(changeStatus(beforeFrame));
    }

    public CalculateStatus getCalculateStatus() {
        return
                scoreCalculator.getCalculateStatus();
    }

//    public CalculateStatus getCalculateStatus() {
//        return calculateStatus;
//    }

    @Override
    public String toString() {
        return toFrameString();
    }

    public void isGivenMessageFromPresentFrame(Frame frame) {
        if (scoreCalculator.isConditionBackward(this, frame)) {
            if (frame.totalScore.isBonusOverThirty()) {
                totalScore.sum(20);
                frame.scoreCalculator.changeCalculateDirectionToLeft();
                return;
            }
            totalScore.sum(frame.totalScore);
        }
        frame.scoreCalculator.changeCalculateDirectionToLeft();
    }

//    public void isGivenMessageFromPresentFrame(Frame frame) {
//        if (calculateStatus != DONE || (isBonus() && calculateStatus == DONE && !frame.isBonus() && !frame.isFrameEnd())) {
//            if (frame.totalScore.isBonusOverThirty()) {
//                totalScore.sum(20);
//                frame.changeCalculateDirectionToLeft();
//                return;
//            }
//            totalScore.sum(frame.totalScore);
//        }
//        frame.changeCalculateDirectionToLeft();
//    }

    boolean isBonus() {
        return isSpare() || isFirstStrike();
    }

    public void isGivenMessageFromBeforeFrame(Frame beforeFrame) {
        if (scoreCalculator.isConditionForward(this)) {
            totalScore.sum(beforeFrame.totalScore);
            scoreCalculator.changeCalculationStatusToDone();
        }
        beforeFrame.scoreCalculator.changeCalculationStatusToDone();
        scoreCalculator.changeCalculateDirectionToRight();
    }

//    public void isGivenMessageFromBeforeFrame(Frame beforeFrame) {
//        if (calculationDirection == LEFT && calculateStatus != DONE && isFrameEnd()) {
//            totalScore.sum(beforeFrame.totalScore);
//            changeCalculationStatusToDone();
//        }
//        beforeFrame.changeCalculationStatusToDone();
//        changeCalculateDirectionToRight();
//    }

    public Score getTotalScore() {
        return totalScore;
    }

    public boolean isCalculationDo() {
        return scoreCalculator.isCalculationDo();
    }

//    public boolean isCalculationDo() {
//        return calculateStatus == DO;
//    }
//
public void changeCalculateDirectionToLeft() {
    scoreCalculator.changeCalculateDirectionToLeft();
}

//    public void changeCalculateDirectionToLeft() {
//        calculationDirection = LEFT;
//    }
//
//    private void changeCalculateDirectionToRight() {
//        calculationDirection = RIGHT;
//    }
//
    public void changeCalculationStatusToDo() {
        scoreCalculator.changeCalculationStatusToDo();
    }
//
//    public void changeCalculationStatusToDone() {
//        calculateStatus = DONE;
//    }

    public void assignFirstState() {
        if (isBonus()) {
            scoreCalculator = ScoreCalculator.of(DONOT);
            return;
        }
        scoreCalculator = ScoreCalculator.of(DONE);
    }

//    public void assignFirstState() {
//        if (isBonus()) {
//            calculateStatus = DONOT;
//            return;
//        }
//        changeCalculationStatusToDone();
//    }

}


