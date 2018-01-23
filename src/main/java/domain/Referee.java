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
        reportFrameResult(fistFrame);

        playBowlingRecursive(fistFrame);
    }

    private void playBowlingRecursive(Frame frame) {
        frame.playNextFrame(this)
             .ifPresent(this::playBowlingRecursive);
    }

    public TotalScore playFrame(int frameNo) {
        FirstScore firstScore = strategy.playFirstScore(frameNo);
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        reportFirstScore(frameNo, firstScore);
        return strategy.playSecondScore(frameNo, firstScore);
    }

    public TotalScore playOnlyFirst(int frameNo) {
        FirstScore firstScore = strategy.playFirstScore(frameNo);
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        return new TotalScore(firstScore, 0);
    }

    public void reportFrameResult(Frame frame) {
        scoreBoard.addFrame(frame);
        scoreBoard.printScoreBoard();
    }

    private void reportFirstScore(int frameNo, FirstScore firstScore) {
        scoreBoard.printFirstScore(frameNo, firstScore);
    }
}
