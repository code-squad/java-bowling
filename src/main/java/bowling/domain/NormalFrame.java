package bowling.domain;

public class NormalFrame extends Frame {
    private Frame nextFrame;

    public NormalFrame(Frame nextFrame) {
        if(nextFrame == null)
            throw new IllegalArgumentException("Next frame can't be a null");

        this.nextFrame = nextFrame;
    }
}
