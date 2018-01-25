package bowling.domain;

import bowling.enums.FrameState;

import java.util.*;
import java.util.stream.Collectors;

import static bowling.common.StaticVariables.FRAME_MAX_VALUE;

public class Frames {
    private List<Frame> frames;

    public Frames() {
        frames = new ArrayList<>(FRAME_MAX_VALUE);

        frames.add(new FinalFrame());
        for(int i = 0 ; i < FRAME_MAX_VALUE - 1; ++i)
            frames.add(new NormalFrame(frames.get(frames.size() - 1)));

        Collections.reverse(frames);
    }

    public FrameState getState(int round) {
        return frame(round).state();
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

    public List<String> getScoreViews() {
        List<String> scores = new ArrayList<>();

        Integer totalScore = 0;
        for(int i = 0 ; i < FRAME_MAX_VALUE ; ++i) {
            totalScore = frames.get(i).getScoreView(totalScore);
            scores.add(totalScore == null ? "   " : String.format("%-3d", totalScore));
        }

        return scores;
    }

    public boolean isEnd() {
        return frame(FRAME_MAX_VALUE - 1).isFrameEnd();
    }
}
