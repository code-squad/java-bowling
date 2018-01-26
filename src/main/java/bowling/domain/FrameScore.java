package bowling.domain;

import java.util.Optional;

public class FrameScore {
    private Integer previousFrameScore;
    private Integer frameScore;
    private Frame frame;

    public FrameScore(Frame frame) {
        this.frame = frame;
    }

    private Optional<Integer> getNextDownPinCount() {
        return frame.getNextFrame().flatMap(Frame::getFirstThrow).map(DownPinCount::getCount);
    }

    private Optional<Integer> getNextTwoDownPinCount() {
        Optional<Integer> nextFirst = getNextDownPinCount();
        Optional<Integer> nextSecond = frame.getNextFrame().flatMap(Frame::getSecondThrow).map(DownPinCount::getCount);
        if(!nextSecond.isPresent() && frame.getNextFrame().map(Frame::isEndFrame).orElse(false))
            nextSecond = frame.getNextFrame().flatMap(Frame::getNextFrame).flatMap(Frame::getFirstThrow).map(DownPinCount::getCount);
        if(nextFirst.isPresent() && nextSecond.isPresent())
            return Optional.of(nextFirst.get() + nextSecond.get());
        return Optional.empty();
    }

    public Optional<Integer> getCurrentFrameScore() {
        if(!frame.isEndFrame())
            return Optional.empty();
        if(!frame.getNextFrame().isPresent())
            return Optional.of(frame.getTotalDownPinCount());
        if(frame.isStrike())
            return getNextTwoDownPinCount().map(score -> score + 10);
        if(frame.isSecondThrowSpare())
            return getNextDownPinCount().map(score -> score + 10);
        return Optional.of(frame.getTotalDownPinCount());
    }

    public Optional<Integer> getScore() {
        if(previousFrameScore != null && frameScore != null)
            return Optional.of(frameScore);
        Optional<Integer> currentFrameScore = getCurrentFrameScore();
        if(previousFrameScore != null && currentFrameScore.isPresent()) {
            setFrameScore(previousFrameScore + currentFrameScore.get());
            frame.getNextFrame().ifPresent(nextFrame -> nextFrame.setPreviousFrameScore(frameScore));
            return Optional.of(frameScore);
        }
        return Optional.empty();
    }

    public void setPreviousFrameScore(int score) {
        previousFrameScore = score;
    }

    private void setFrameScore(int score) {
        frameScore = score;
    }
}
