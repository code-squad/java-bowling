package bowling.domain;

import bowling.enums.FrameStatus;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int FRAME_MAX_VALUE = 10;

    private List<Frame> frames;

    public Frames() {
        frames = new ArrayList<>(FRAME_MAX_VALUE);

        for(int i = 0 ; i < FRAME_MAX_VALUE ; ++i)
            frames.add(new Frame());
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

    public String printFrames() {
        StringBuilder sb = new StringBuilder();

        frames.stream()
                .map(f -> f.printFrame() + "|")
                .forEach(sb::append);

        return sb.toString();
    }

    public boolean isCurrentFrameEnd(CurrentInfo currentInfo) {
        return frames.get(currentInfo.getCurrentRound())
                .isFrameEnd();
    }
}
