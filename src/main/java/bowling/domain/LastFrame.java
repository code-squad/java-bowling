package bowling.domain;


import javax.annotation.Nonnull;
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

    private boolean canThrowThirdBall() {
        return isStrike(getFirstThrow().get()) || isSecondThrowSpare();
    }

    private boolean isThirdThrowSpare() {
        return sumDownPinCount(getSecondThrow().get(), thirdThrow) == 10 && !isStrike(getSecondThrow().get());
    }

    private Optional<DownPinCount> getThirdThrow() {
        return Optional.ofNullable(thirdThrow);
    }

    @Override
    protected int getTotalDownPinCount() {
        return super.getTotalDownPinCount() + getThirdThrow().map(DownPinCount::getCount).orElse(0);
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
