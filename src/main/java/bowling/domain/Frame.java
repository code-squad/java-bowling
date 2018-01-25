package bowling.domain;

import java.util.Optional;

public class Frame {
    private DownPinCount firstThrow;
    private DownPinCount secondThrow;
    private Frame nextFrame;

    Frame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public boolean add(DownPinCount result) {
        if (firstThrow == null) {
            firstThrow = result;
        }else if (secondThrow == null)
            secondThrow = result;
        return isEnd();
    }

    public boolean isEnd() {
        return getTotalDownPinCount() == 10 || secondThrow != null;
    }

    public int getTotalDownPinCount() {
        return getFirstThrow().orElse(DownPinCount.of(0))
                .add(getSecondThrow().orElse(DownPinCount.of(0))).getCount();
    }

    protected boolean isStrike(Optional<DownPinCount> throwBallResult) {
        return throwBallResult.map(DownPinCount::isAllDown).orElse(false);
    }

    protected int getDownPinCount(Optional<DownPinCount> throwBallResult) {
        return throwBallResult.map(DownPinCount::getCount).orElse(0);
    }

    public Optional<Frame> getNextFrame() {
        return Optional.ofNullable(nextFrame);
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
                .map(str -> getTotalDownPinCount() == 10 ? "/" : str)
                .orElse("");
        return first + separator + second;
    }
}