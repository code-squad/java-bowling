package bowling.domain;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrameManager {
    private LinkedList<Frame> frames;

    private FrameManager(LinkedList<Frame> frames) {
        this.frames = frames;
    }

    public static FrameManager of() {
        LinkedList<Frame> frames = IntStream
                                    .range(0, BowlingConstants.FRAME_COUNT - 1)
                                    .mapToObj(i -> new NormalFrame())
                                    .collect(Collectors.toCollection(LinkedList::new));
        frames.add(new LastFrame());

        return new FrameManager(frames);
    }

    public void shot(Try thisTry) {
        frames.stream()
                .filter(Frame::notYet)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Everything is already done. please check, thisTry=" + thisTry))
                .setTry(thisTry);
    }

    public boolean isFinish() {
        return frames.stream()
                .noneMatch(Frame::notYet);
    }

    public String showMessage() {
        return frames.stream()
                .map(Frame::showMessage)
                .collect(Collectors.joining("|"));

    }

    public String showHeader() {
        return IntStream
                .range(1, frames.size() + 1)
                .mapToObj(i -> String.format("  %d  ", i))
                .collect(Collectors.joining("|"));
    }
}
