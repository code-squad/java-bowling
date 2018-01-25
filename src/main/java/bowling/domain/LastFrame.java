package bowling.domain;

import java.util.Optional;

public class LastFrame implements Frame {
    private Optional<Try> thirdTry;
    private NormalFrame normalFrame;

    public LastFrame() {
        thirdTry = Optional.empty();
        normalFrame = new NormalFrame();
    }

    @Override
    public boolean notYet() {
        return !(normalFrame.isPresentEverything())
                || (!thirdTry.isPresent() && normalFrame.isSpareOrStrike());
    }

    @Override
    public void setTry(Try eachTry) {
        if ( !notYet()) {
            throw new IllegalStateException("setTry is not valid, try=" + eachTry);
        }
        setTryInner(eachTry);
        validate();
    }

    private boolean setTryInner(Try eachTry) {
        if ( !normalFrame.setTryInner(eachTry) && !thirdTry.isPresent()) {
            thirdTry = Optional.of(eachTry);
            return true;
        }
        return false;
    }

    private void validate() {
        if ( !normalFrame.isFirstStrike()) {
            normalFrame.validate();
        }

        if ( !normalFrame.isSpare() && !normalFrame.isSecondStrike()) {
            normalFrame.validateWithSecondAnd(thirdTry);
        }
    }

    @Override
    public String showMessage() {
        if (normalFrame.isSecondStrike()) {
            return "X|X" + (normalFrame.isStrike(thirdTry) ? "|X" : getThirdDownMessage());
        }

        return " " + normalFrame.showDefaultMessage() + getThirdDownMessage();
    }

    private String getThirdDownMessage() {
        if ( !thirdTry.isPresent()) {
            return " ";
        }
        return "|" + normalFrame.getDownMessage(thirdTry);
    }
}
