package bowling.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrameManager {
    private List<Frame> frames;

    private FrameManager(List<Frame> frames) {
        this.frames = frames;
    }

    public static FrameManager of() {
        List<Frame> frames = IntStream
                                    .range(0, BowlingConstants.FRAME_COUNT - 1)
                                    .mapToObj(i -> new NormalFrame())
                                    .collect(Collectors.toCollection(ArrayList::new));
        frames.add(new LastFrame());

        for (int i=0; i<BowlingConstants.FRAME_COUNT -1; i++) {
            Frame thisFrame = frames.get(i);
            Frame nextFrame = frames.get(i+1);
            thisFrame.setNextFrame(nextFrame);
        }

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

    public String showScore() {
        return frames.stream()
                .map(Frame::showScore)
                .collect(Collectors.joining("|"));

    }

    public String showHeader() {
        return IntStream
                .range(1, frames.size() + 1)
                .mapToObj(i -> String.format("  %d  ", i))
                .collect(Collectors.joining("|"));
    }
}
