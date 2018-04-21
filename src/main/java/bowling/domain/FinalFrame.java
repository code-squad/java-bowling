package bowling.domain;

import java.util.Iterator;

public class FinalFrame extends Frame {

    private Frame prevFrame;

    public FinalFrame() {}

    public FinalFrame(Frame prevFrame) {
        super();
        this.prevFrame = prevFrame;
    }

    public Iterator iterator() {
        return new FinalFrameIterator(this);
    }

    @Override
    public int score() {
        // 점수 구현은 다음 단계에
        return 0;
    }

    @Override
    public String toString() {
        String scoreText = score.toString()
                .replaceAll("10", frameStatus.symbol().trim());

        if (FrameStatus.STRIKE.equals(frameStatus)) {
            return scoreText;
        }

        if (FrameStatus.SPARE.equals(frameStatus)) {
            return scoreText.split("|")[0] + "|" + frameStatus.symbol() + " ";
        }

        if (FrameStatus.MISS.equals(frameStatus)) {
            return scoreText + " ";
        }

        if (FrameStatus.GUTTER.equals(frameStatus)) {
            return frameStatus.symbol() + "|" + frameStatus.symbol();
        }

        return " " + scoreText + "  ";
    }
}
