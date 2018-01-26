package bowling.domain;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class BowlingGame {
    private LinkedList<Frame> frames;
    private Frame currentFrame;

    public BowlingGame() {
        this.frames = new LinkedList<>();
        this.frames.add(new LastFrame());
        IntStream.range(0, 9)
                .forEach(i -> {
                    Frame nextFrame = frames.getFirst();
                    frames.addFirst(new Frame(nextFrame));
                });
        currentFrame = frames.getFirst();
    }

    public void throwBall(@Nonnull DownPinCount count) {
        if(currentFrame.add(count)) {
            currentFrame = currentFrame.getNextFrame().orElse(currentFrame);
        }
    }

    public int getCurrentFrameNo() {
        return frames.indexOf(currentFrame) + 1;
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(frames);
    }

    public boolean isEndGame() {
        return currentFrame.isEndGame();
    }
}
