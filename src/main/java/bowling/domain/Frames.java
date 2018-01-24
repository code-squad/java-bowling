package bowling.domain;

import bowling.enums.FrameState;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bowling.common.StaticVariables.FRAME_MAX_VALUE;

public class Frames {
    private List<Frame> frames;

    public Frames() {
        frames = IntStream.range(0, FRAME_MAX_VALUE -1)
                .mapToObj(i -> new Frame())
                .collect(Collectors.toList());

        frames.add(new FinalFrame());
    }

    public FrameState getState(int round) {
        return frame(round).status();
    }

    private Frame frame(int round) {
        return frames.get(round);
    }

    public void rollBowlingBall(int round, Pin fellPin) {
        frame(round).rollBowlingBall(fellPin);
    }

    public boolean isCurrentFrameEnd(int frameNo) {
        return frame(frameNo).isFrameEnd();
    }

    public List<String> getFrameViews() {
        return frames.stream()
                .map(Frame::getFrameView)
                .collect(Collectors.toList());
    }

    public boolean isEnd() {
        return frame(FRAME_MAX_VALUE - 1).isFrameEnd();
    }
}
