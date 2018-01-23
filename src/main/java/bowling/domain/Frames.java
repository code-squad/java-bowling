package bowling.domain;

import bowling.enums.FrameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frames {
    private static final int FRAME_MAX_VALUE = 10;

    private List<Frame> frames;

    public Frames() {
        frames = new ArrayList<>(FRAME_MAX_VALUE);

        for(int i = 0 ; i < FRAME_MAX_VALUE - 1 ; ++i)
            frames.add(new Frame());

        frames.add(new FinalFrame());
    }

    public FrameStatus getState(int round) {
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
}
