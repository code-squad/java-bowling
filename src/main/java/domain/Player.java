package domain;

import state.FirstBowl;
import state.State;

public class Player {
    private final String name;
    private Frames frames;
    private Frame frame;

    public Player(String name) {
        this.name = name;
        frames = new Frames();
        frame = frames.createFirstFrame();
    }

    // getter와 동일한 역할인데, 어떻게 변경해주면 좋을까
    public String printName() {
        return name;
    }

    public String printPlayingFrameState() {
        return frame.printState();
    }

    public State bowl(int falledPin) {
        State state = frame.bowl(falledPin);
        System.out.println(FirstBowl.isFirstBowl(state));
        if (frame.isEnd()) {
            saveFrameData();
            return state;
        }
        return state;
    }

    public boolean isEnd() {
        return frame.isEnd();
    }

    public int getFinishedFrame() {
        return frames.getFinishedFrame();
    }

    public void saveFrameData() {
        frames.add(frame);
    }

    public String printFramesState(int index) {
        return frames.printFramesState(index);
    }

    public int printFramesScore(int index, int beforeScore) {
        return frames.printFramesScore(index, beforeScore);
    }

    public Frame nextFrame() {
        return frame = frame.next();
    }

    public boolean isLastFrame() {
        return frame.isLastFrame();
    }

    public String printLastFrameState() {
        if (frame.isLastFrame()) {
            return frame.printState();
        }
        throw new RuntimeException("마지막 프레임이 아닙니다.");
    }
}
