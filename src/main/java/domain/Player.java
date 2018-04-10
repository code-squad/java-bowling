package domain;

import domain.frame.Frames;
import domain.frame.result.FrameResults;

public class Player {
    private PlayerName name;
    private Frames frames;
    private FrameResults results;

    public Player(String name) throws IllegalArgumentException {
        this.name = new PlayerName(name);
        frames = new Frames();
        results = new FrameResults();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isFinish() {
        return frames.isFinish();
    }

    public void recordPins(int pins) throws IllegalArgumentException {

        /*
            TODO : 여기부터 생각해보기 - 정규 투구, 보너스 투구 기록, 각각 다른 메소드?
            Frame currentFrame = frames.getCurrentFrame();
            int currentFrameNum = frames.getCurrentFrameNum();
        */

    }

    public int getCurrentFrameNum() {
        return frames.getCurrentFrameNum();
    }
}
