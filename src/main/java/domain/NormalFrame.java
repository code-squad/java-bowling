package domain;

public class NormalFrame extends Frame {

    private NormalFrame() {
        super();
    }

    public static Frame of() {
        return new NormalFrame();
    }

    @Override
    public boolean isFrameEnd() {
        return isStrike(0) || isTrySecond();
    }

}
