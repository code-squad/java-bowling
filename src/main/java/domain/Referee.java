package domain;

import domain.frame.Frame;
import domain.frame.NormalFrame;
import domain.score.FirstScore;
import domain.score.TotalScore;

public class Referee {

    private final PlayStrategy strategy;

    private final ScoreBoard scoreBoard;

    public Referee(PlayStrategy strategy, ScoreBoard scoreBoard) {
        this.strategy = strategy;
        this.scoreBoard = scoreBoard;
    }

    public void playBowling() {
        Frame fistFrame = new NormalFrame(playFrame(1), 1);

        playBowlingRecursive(fistFrame);
    }

    private void playBowlingRecursive(Frame frame) {
        frame.playNextFrame(this)
             .ifPresent(this::playBowlingRecursive);
    }

    public TotalScore playFrame(int frameNo) {
        FirstScore firstScore = strategy.playFirstScore(frameNo);
        scoreBoard.printFirstScore(frameNo, firstScore);
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        TotalScore totalScore = new TotalScore(firstScore, strategy.playSecondScore(frameNo, firstScore));
        scoreBoard.printTotalScore(frameNo, totalScore);
        return totalScore;
    }

    public TotalScore playOnlyFirst(int frameNo) {
        FirstScore firstScore = strategy.playFirstScore(frameNo);
        scoreBoard.printFirstScore(frameNo, firstScore);
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        return new TotalScore(firstScore, 0);
    }
}
