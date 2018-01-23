package bowling.domain;

import java.util.Optional;

public class Frame {
    protected Optional<Try> firstTry;
    protected Optional<Try> secondTry;

    public Frame() {
        firstTry = Optional.empty();
        secondTry = Optional.empty();
    }

    protected boolean isStrike(Optional<Try> thisTry) {
        return thisTry.filter(Try::isStrike).isPresent();
    }

    protected boolean isSpare() {
        return firstTry.filter(t -> t.isSpare(secondTry)).isPresent();
    }

    public boolean notYet() {
        return !isStrike(firstTry) && !(firstTry.isPresent() && secondTry.isPresent());
    }

    public void setTry(Try eachTry) {
        if ( !notYet()) {
            throw new IllegalStateException("setTry is not valid, try=" + eachTry);
        }
        setTryInner(eachTry);
        validate();
    }

    protected void validate() {
        firstTry.orElse(Try.empty())
                .validate(secondTry.orElse(Try.empty()));
    }

    protected boolean setTryInner(Try eachTry) {
        if ( !firstTry.isPresent()) {
            firstTry = Optional.of(eachTry);
            return true;
        }

        if ( !secondTry.isPresent()) {
            secondTry = Optional.of(eachTry);
            return true;
        }

        return false;
    }

    public String showMessage() {
        return showDefaultMessage() + " ";
    }

    protected String showDefaultMessage() {
        if (isStrike(firstTry)) {
            return "  X ";
        }

        if (isSpare()) {
            return " " + getEachTry(firstTry).getDownMessage() + "|/";
        }

        String message = " ";
        if (firstTry.isPresent()) {
            message += getEachTry(firstTry).getDownMessage();
        } else {
            message += " ";
        }

        if (secondTry.isPresent()) {
            message += "|" + getEachTry(secondTry).getDownMessage();
        } else {
            message += "  ";
        }

        return message;
    }

    protected Try getEachTry(Optional<Try> thisTry) {
        return thisTry.orElseThrow(() -> new IllegalStateException("invalid state, frame" + this));
    }
}
