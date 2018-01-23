package bowling.domain;

import java.util.Optional;

public class LastFrame extends Frame {
    private Optional<Try> thirdTry = Optional.empty();

    @Override
    public boolean notYet() {
        return !(firstTry.isPresent() && secondTry.isPresent())
                || (!thirdTry.isPresent() && isSpecial());
    }

    private boolean isSpecial() {
        return isSpare() || isStrike(firstTry);
    }

    @Override
    protected boolean setTryInner(Try eachTry) {
        if ( !super.setTryInner(eachTry) && !thirdTry.isPresent()) {
            thirdTry = Optional.of(eachTry);
            return true;
        }
        return false;
    }

    @Override
    protected void validate() {
        if ( !isStrike(firstTry)) {
            firstTry.orElse(Try.empty())
                    .validate(secondTry.orElse(Try.empty()));
        }

        if ( !isSpare() && !isStrike(secondTry)) {
            secondTry.orElse(Try.empty())
                    .validate(thirdTry.orElse(Try.empty()));
        }

    }

    @Override
    public String showMessage() {
        if ( !isSpecial()) {
            return super.showMessage();
        }

        if (!secondTry.isPresent()) {
            return super.showMessage();
        }

        if (isStrike(secondTry)) {
            return "X|X" + (isStrike(thirdTry) ? "|X" : getThirdDownMessage());
        }

        return showDefaultMessage() + getThirdDownMessage();
    }

    private String getThirdDownMessage() {
        if ( !thirdTry.isPresent()) {
            return " ";
        }
        return "|" + getEachTry(thirdTry).getDownMessage();
    }
}
