package bowling.domain;


import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Optional;

public class LastFrame extends Frame{

    private DownPinCount thirdThrow;

    LastFrame() {
        super(null);
    }

    @Override
    public boolean add(@Nonnull DownPinCount result) {
        if(!getSecondThrow().isPresent())
            super.add(result);
        else if(canThrowThirdBall() && thirdThrow == null) {
            thirdThrow = result;
            return true;
        }
        return isEnd();
    }

    @Override
    public boolean isEnd() {
        if (canThrowThirdBall()) {
            return thirdThrow != null;
        }
        return getSecondThrow().isPresent();
    }

    @Override
    public boolean isEndGame() {
        return isEnd();
    }

    private boolean isStrike(Optional<DownPinCount> throwBallResult) {
        return throwBallResult.map(DownPinCount::isAllDown).orElse(false);
    }

    private boolean canThrowThirdBall() {
        return isStrike(getFirstThrow()) || isSecondThrowSpare();
    }

    private boolean isSecondThrowSpare() {
        return sumDownPinCount(getFirstThrow(), getSecondThrow()) == 10 && !isStrike(getFirstThrow());
    }

    private boolean isThirdThrowSpare() {
        return sumDownPinCount(getSecondThrow(), getThirdThrow()) == 10 && !isStrike(getSecondThrow());
    }

    private int sumDownPinCount(Optional<DownPinCount>... throwBallResults) {
        return Arrays.stream(throwBallResults)
                .mapToInt(result -> result.map(DownPinCount::getCount).orElse(0))
                .sum();
    }

    private Optional<DownPinCount> getThirdThrow() {
        return Optional.ofNullable(thirdThrow);
    }

    @Override
    protected int getTotalDownPinCount() {
        return sumDownPinCount(getFirstThrow(), getSecondThrow(), getThirdThrow());
    }

    @Override
    public String getFrameInfoWithFormat() {
        return String.format(" %-5s", getFrameInfo());
    }

    @Override
    public String getFrameInfo() {
        String first = getFirstThrow()
                .map(DownPinCount::toString)
                .orElse("");
        String separator1 = getSecondThrow().isPresent() ? "|" : "";
        String second = getSecondThrow()
                .map(DownPinCount::toString)
                .map(str -> isSecondThrowSpare() ? "/" : str)
                .orElse("");
        String separator2 = getThirdThrow().isPresent() ? "|" : "";
        String third = getThirdThrow()
                .map(DownPinCount::toString)
                .map(str -> isThirdThrowSpare() ? "/" : str)
                .orElse("");
        return first + separator1 + second + separator2 + third;
    }
}
