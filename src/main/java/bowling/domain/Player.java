package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int LAST = 9;
    private final String name;
    private final List<Frame> frames;
    private int previouslyPlayed;

    public Player(String name) {
        this.name = name;
        this.frames = initializeFrames();
    }

    private static List<Frame> initializeFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int frameCount = 0; frameCount < LAST - 1; frameCount++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        return frames;
    }

    public int getPreviousFrameNumber() {
        return previouslyPlayed;
    }

    public boolean isLastFrame() {
        return previouslyPlayed == LAST;
    }

    private void updatePreviousFrameNumber() {
        previouslyPlayed++;
    }

    private Frame NextFrame() {
        return frames.get(previouslyPlayed);
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

    public Integer getFirstScoreOnFrame(int frameNumber) {
        return frames.get(frameNumber).getFirstScore();
    }

    public Integer getSecondScoreOnFrame(int frameNumber) {
        return frames.get(frameNumber).getSecondScore();
    }

    public Integer getThirdScoreOnLastFrame() {
        return frames.get(LAST).
    }

    public boolean isStrikeOnFrame(int frameNumber) {
        return frames.get(frameNumber).isStrike();
    }
}