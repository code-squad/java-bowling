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
        return isEndFrame();
    }

    @Override
    public boolean isEndFrame() {
        if (canThrowThirdBall()) {
            return thirdThrow != null;
        }
        return getSecondThrow().isPresent();
    }

    @Override
    public boolean isEndGame() {
        return isEndFrame();
    }

    private boolean canThrowThirdBall() {
        return isStrike(getFirstThrow().orElse(null)) || isSecondThrowSpare();
    }

    private boolean isThirdThrowSpare() {
        return getSecondThrow().isPresent() && thirdThrow != null &&
                !isStrike(getSecondThrow().get()) && getSecondThrow().get().isSpare(thirdThrow) ;
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
