package bowling.domain;

import java.util.Iterator;

public class NormalFrame extends Frame {

    private Frame prevFrame;
    private Frame nextFrame;

    public NormalFrame() {}

    public NormalFrame(Frame prevFrame, Frame nextFrame) {
        super();
        this.prevFrame = prevFrame;
        this.nextFrame = nextFrame;
    }

    public Iterator iterator() {
        return new NormalFrameIterator(this);
    }

    @Override
    public int score() {
        // 점수 구현은 다음 단계에
        return 0;
    }

    @Override
    public String toString() {
        if (FrameStatus.STRIKE.equals(frameStatus)) {
            return " " + frameStatus.symbol() + " ";
        }

        if (FrameStatus.SPARE.equals(frameStatus)) {
            return score.toString().split("|")[0] + "|" + frameStatus.symbol() + " ";
        }

        if (FrameStatus.MISS.equals(frameStatus)) {
            return score.toString() + " ";
        }

        if (FrameStatus.GUTTER.equals(frameStatus)) {
            return frameStatus.symbol() + "|" + frameStatus.symbol();
        }

        return " " + score.toString() + "  ";
    }
}
