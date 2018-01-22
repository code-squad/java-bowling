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
        NormalFrame normalFrame = playFirstFrame();

        playBowlingRecursive(normalFrame);
    }

    private void playBowlingRecursive(Frame normalFrame) {
        normalFrame.playNextFrame(this)
                   .ifPresent(this::playBowlingRecursive);
    }

    private NormalFrame playFirstFrame() {
        FirstScore firstScore = strategy.playFirstScore(1);
        if (firstScore.isStrike()) {
            NormalFrame first = new NormalFrame(new TotalScore(firstScore), 1);
            scoreBoard.printFrame(first);

            return first;
        }
        TotalScore totalScore = new TotalScore(firstScore, strategy.playSecondScore(1, firstScore));
        NormalFrame firstFrame = new NormalFrame(totalScore, 1);
        scoreBoard.printFrame(firstFrame);
        return firstFrame;
    }

    public TotalScore playNextFrame(Frame frame) {
        FirstScore firstScore = strategy.playFirstScore(frame.getFrameNo());
        scoreBoard.printFirstScore(frame, firstScore);
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        TotalScore totalScore = new TotalScore(firstScore, strategy.playSecondScore(frame.getFrameNo(), firstScore));
        scoreBoard.printTotalScore(frame, totalScore);
        return totalScore;
    }

    public TotalScore playOnlyFirst(Frame frame) {
        FirstScore firstScore = strategy.playFirstScore(frame.getFrameNo());
        scoreBoard.printFirstScore(frame, firstScore);
        if (firstScore.isStrike()) {
            return new TotalScore(firstScore);
        }
        return new TotalScore(firstScore, 0);
    }
}
