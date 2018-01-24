package domain;

import domain.frame.BowlingGame;
import domain.frame.Frame;
import domain.frame.NormalFrame;
import domain.score.Score;
import domain.score.TotalScore;

public class Player {

    private final PlayStrategy strategy;

    private final ScoreBoard scoreBoard;

    private final BowlingGame bowlingGame;

    public Player(String playerName, PlayStrategy strategy, ScoreBoard scoreBoard) {
        if (strategy == null || scoreBoard == null) {
            throw new IllegalArgumentException();
        }
        this.strategy = strategy;
        this.scoreBoard = scoreBoard;
        this.bowlingGame = new BowlingGame(playerName);
        this.scoreBoard.printGameResult(bowlingGame);
    }

    public void playBowling() {
        Score firstScore = play(1);
        Frame frame = new NormalFrame(new TotalScore(firstScore), 1);
        addFrame(frame);

        if (!firstScore.isStrike()) {
            frame.addSecondScore(play(1));
            notifyFrameChanged();
        }

        playBowlingRecursive(frame);
    }

    private void playBowlingRecursive(Frame frame) {
        frame.playNextFrame(this)
             .ifPresent(this::playBowlingRecursive);
    }

    public Score play(int frameNo) {
        return strategy.play(frameNo);
    }

    public void addFrame(Frame frame) {
        bowlingGame.addFrame(frame);
        notifyFrameChanged();
    }

    public void notifyFrameChanged() {
        this.scoreBoard.printGameResult(bowlingGame);
    }

}
