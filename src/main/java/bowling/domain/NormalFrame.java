package bowling.domain;

import java.util.Optional;

public class NormalFrame implements Frame {
    private Optional<Try> firstTry;
    private Optional<Try> secondTry;
    private Frame nextFrame;

    public NormalFrame() {
        firstTry = Optional.empty();
        secondTry = Optional.empty();
    }

    protected boolean isFirstStrike() {
        return isStrike(firstTry);
    }

    protected boolean isSecondStrike() {
        return isStrike(secondTry);
    }

    protected boolean isStrike(Optional<Try> thisTry) {
        return thisTry.filter(Try::isStrike).isPresent();
    }

    protected boolean isSpare() {
        return firstTry.filter(t -> t.isSpare(secondTry)).isPresent();
    }

    @Override
    public boolean notYet() {
        return !isStrike(firstTry) && !isPresentEverything();
    }

    public boolean isPresentEverything() {
        return firstTry.isPresent() && secondTry.isPresent();
    }

    @Override
    public void setTry(Try eachTry) {
        if ( !notYet()) {
            throw new IllegalStateException("setTry is not valid, try=" + eachTry);
        }
        setTryInner(eachTry);
        validate();
    }

    protected void validate() {
        validate(firstTry, secondTry);
    }

    private void validate(Optional<Try> firstTry, Optional<Try> secondTry) {
        firstTry.orElse(Try.empty())
                .validate(secondTry.orElse(Try.empty()));
    }

    public void validateWithSecondAnd(Optional<Try> thirdTry) {
        validate(secondTry, thirdTry);
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

    @Override
    public String showMessage() {
        return " " + showDefaultMessage() + " ";
    }

    @Override
    public String showScore() {
        int score = notYet() ? 0 : getBothDownCount();
        int bonusScore = isSpareOrStrike() ? nextFrame.getBonusScore(isSpare()) : 0;

        return Score.show(score + bonusScore);
    }

    private int getBothDownCount() {
        return getFirstDownCount()
                + getSecondDownCount();
    }

    private int getSecondDownCount() {
        return secondTry.orElse(Try.empty()).getDownCount();
    }

    private int getFirstDownCount() {
        return firstTry.orElse(Try.empty()).getDownCount();
    }

    @Override
    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    @Override
    public int getBonusScore(boolean spare) {
        return spare ? this.getFirstDownCount() : this.getBothDownCount();
    }

    protected String showDefaultMessage() {
        if (isStrike(firstTry)) {
            return " X ";
        }

        String message = getDownMessage(firstTry);

        if ( !secondTry.isPresent()) {
            return message + "  ";
        }

        message += "|";
        message += getDownMessage(secondTry);

        return message;
    }

    protected String getDownMessage(Optional<Try> thisTry) {
        if ( !thisTry.isPresent()) {
            return " ";
        }

        if (secondTry.equals(thisTry) && isSpare()) {
            return "/";
        }
        return thisTry.get().getDownMessage();
    }

    protected boolean isSpareOrStrike() {
        return isSpare() || isStrike(firstTry);
    }

    @Override
    public String toString() {
        return "NormalFrame{" +
                "firstTry=" + firstTry +
                ", secondTry=" + secondTry +
                ", nextFrame=" + nextFrame +
                '}';
    }
}
