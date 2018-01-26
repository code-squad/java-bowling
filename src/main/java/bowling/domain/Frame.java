package bowling.domain;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Optional;

public class Frame {
    private DownPinCount firstThrow;
    private DownPinCount secondThrow;
    private Frame nextFrame;

    Frame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public boolean add(@Nonnull DownPinCount result) {
        if (firstThrow == null) {
            firstThrow = result;
        }else if (secondThrow == null)
            secondThrow = result;
        return isEnd();
    }

    public boolean isEnd() {
        return getTotalDownPinCount() == 10 || secondThrow != null;
    }

    public boolean isEndGame() {
        return false;
    }

    protected boolean isStrike(DownPinCount throwBallResult) {
        return throwBallResult != null && throwBallResult.isStrike();
    }

    protected boolean isSecondThrowSpare() {
        return firstThrow != null && secondThrow != null &&
                firstThrow.isSpare(secondThrow) && !isStrike(firstThrow);
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