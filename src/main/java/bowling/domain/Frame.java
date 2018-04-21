package bowling.domain;

import java.util.Iterator;

public abstract class Frame {

    FrameStatus frameStatus;
    Score score;

    Frame() {
        this.frameStatus = FrameStatus.PLAYING;
        this.score = new Score();
    }

    public Frame shot(int numberOfPin, boolean hasNext) {
        score.sum(new Shot(numberOfPin));
        frameStatus = score.status(hasNext);

        return this;
    }

    abstract Iterator iterator();
    abstract int score();
}
