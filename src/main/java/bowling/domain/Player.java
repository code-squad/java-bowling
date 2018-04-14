package bowling.domain;

import bowling.domain.Util.ScoreCalculator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Frame> frames;
    private int previouslyPlayed;

    public Player(String name) {
        this.name = name;
        this.frames = initializeFrames();
    }

    private static List<Frame> initializeFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int frameCount = 0; frameCount < 8; frameCount++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        return frames;
    }

    private void updatePreviousFrameNumber() {
        previouslyPlayed++;
    }

    private Frame NextFrame() {
        return frames.get(previouslyPlayed);
    }

    public List<Integer> calculateFrameScores() {
        ScoreCalculator calculator = new ScoreCalculator(frames);
        return calculator.calculateScores();
    }

    public void throwBall(int pinsKnocked) {
        try {
            Frame frame = NextFrame();
            frame.throwBall(pinsKnocked);
            if (frame.isStrike() || frame.secondBallPlayed()) {
                updatePreviousFrameNumber();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getPreviousFrameNumber() {
        return previouslyPlayed;
    }

    public boolean isLastFrame() {
        return previouslyPlayed == 9;
    }
}