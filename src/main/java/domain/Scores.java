package domain;

import domain.status.FrameStatus;
import domain.status.Open;
import domain.status.Spare;
import domain.status.Strike;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.BowlingUtils.totalScore;
import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public class Scores {

    private List<Score> scores;
    private FrameStatus frameStatus;

    private Scores() {
        scores = new ArrayList<>();
    }

    public static Scores of () {
        return new Scores();
    }

    public void assignStatus(int countOfPins) {
        scores.add(Score.of(countOfPins));
        System.out.printf("스코어가 추가되었으니 사이즈 증가 : %d\n", scores.size());
        if (isStrikeCondition(scores)) {
            System.out.println("스트라이크 상태 할당");
            frameStatus = Strike.of();
            return;
        }
        if (isSpareCondition(scores)) {
            System.out.println("스트라이크 상태 할당");
            frameStatus = Spare.of();
            return;
        }
        if (scores.size() == 2 && scores.get(1).isTen() || scores.size() == 2 && scores.get(0).isTen()) {
            System.out.println("보너스 상태 할당");
            frameStatus = Strike.of();
            return;
        }
        if (scores.size() == 3) {
            System.out.println("보너스 상태 할당");
            frameStatus = Strike.of();
            return;
        }
        System.out.println("오픈프레임 상태 할당");
        frameStatus = Open.of(2 - scores.size());
    }

    public boolean isEnd() {
        if (frameStatus == null) {
            System.out.println("frameStatus is null");
            return false;
        }
        return frameStatus.isEnd();
    }

    private boolean isSpareCondition(List<Score> scores) {
        return scores.size() == 2 && totalScore(scores) == 10;
    }

    private boolean isStrikeCondition(List<Score> scores) {
        return scores.size() == 1 && scores.get(0).isTen();
    }

    public void takeFromPresent(Scores presentScores) {
        frameStatus.takeAdditionalFromPresent(presentScores.frameStatus, presentScores.scores);
    }

    public void takeFromBefore(Scores beforeScores) {
        frameStatus.takeAdditionalFromBefore(beforeScores.frameStatus, beforeScores.scores);
    }

    public void changeDo() {
        frameStatus.changeDo();
    }

    public boolean isDo() {
        return frameStatus.isDo();
    }

    public void changeNotYet() {
        frameStatus.changeNotYet();
    }

    public boolean isSpare() {
        return frameStatus.isSpare();
    }

    public boolean isStrike() {
        return frameStatus.isStrike();
    }

    public boolean isOpen() {
        return frameStatus.isOpen();
    }

    boolean isValidScore(final int score, int compareIndex) {
        if (compareIndex == 0) {
            return Score.of().isValidAdditionScore(score);
        }
        return scores.get(compareIndex).isValidAdditionScore(score);
    }

    public String toScoreString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining(FRAMEBAR.toString()));
    }

    public String spareString() {
        return scores.get(0).toString() + FRAMEBAR + SPARE;
    }

    public int getTotalScore() {
        if (frameStatus == null) {
            return 0;
        }
        return frameStatus.calcTotal(scores);
    }

}
