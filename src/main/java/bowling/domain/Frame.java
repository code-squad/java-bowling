package bowling.domain;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Optional;

public class Frame {
    private DownPinCount firstThrow;
    private DownPinCount secondThrow;
    private Frame nextFrame;
    private FrameScore frameScore;

    Frame(Frame nextFrame) {
        this.nextFrame = nextFrame;
        this.frameScore = new FrameScore(this);
    }

    public boolean add(@Nonnull DownPinCount result) {
        if (firstThrow == null) {
            firstThrow = result;
        }else if (secondThrow == null)
            secondThrow = result;
        return isEndFrame();
    }

    public boolean isEndFrame() {
        return isStrike(firstThrow) || isSecondThrowSpare() || secondThrow != null;
    }

    public boolean isEndGame() {
        return false;
    }

    public boolean isStrike() {
        return isStrike(firstThrow);
    }

    protected boolean isStrike(DownPinCount throwBallResult) {
        return throwBallResult != null && throwBallResult.isStrike();
    }

    protected boolean isSecondThrowSpare() {
        return firstThrow != null && secondThrow != null &&
                !isStrike(firstThrow) && firstThrow.isSpare(secondThrow);
    }

    public Optional<Frame> getNextFrame() {
        return Optional.ofNullable(nextFrame);
    }

    protected int getTotalDownPinCount() {
        return sumDownPinCount(firstThrow, secondThrow);
    }

    protected int sumDownPinCount(DownPinCount... throwBallResults) {
        return Arrays.stream(throwBallResults)
                .mapToInt(result -> result == null ? 0 : result.getCount())
                .sum();
    }

    protected Optional<DownPinCount> getFirstThrow() {
        return Optional.ofNullable(firstThrow);
    }

    protected Optional<DownPinCount> getSecondThrow() {
        return Optional.ofNullable(secondThrow);
    }

    public void setPreviousFrameScore(int score) {
        frameScore.setPreviousFrameScore(score);
    }

    public Optional<Integer> getScore() {
        return frameScore.getScore();
    }

    public String getFrameInfoWithFormat() {
        return String.format("  %-3s ", getFrameInfo());
    }

    public String getFrameInfo() {
        String first = getFirstThrow()
                .map(DownPinCount::toString)
                .orElse("");
        String separator = secondThrow == null ? "" : "|";
        String second = getSecondThrow()
                .map(DownPinCount::toString)
                .map(str -> isSecondThrowSpare() ? "/" : str)
                .orElse("");
        return first + separator + second;
    }
}