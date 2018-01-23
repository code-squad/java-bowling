package bowling.domain;

import bowling.enums.FrameStatus;

import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private Frames frames;
    private int frameNo;

    public Player(String name) {
        inputValidationCheck(name);

        this.name = name;
        this.frames = new Frames();
        this.frameNo = 0;
    }

    private void inputValidationCheck(String name) {
        if(name == null || name.length() != 3)
            throw new IllegalArgumentException("name must be three english letter");
    }

    public FrameStatus getState() {
        return frames.getState(frameNo);
    }

    public FrameStatus getPreviousState() {
        if(frameNo < 1)
            throw new IllegalArgumentException("There is no previous frame of first frame");

        return frames.getState(frameNo - 1);
    }

    public void rollBowlingBall(Pin pin) {
        frames.rollBowlingBall(frameNo, pin);
    }

    public boolean isCurrentFrameEnd() {
        return frames.isCurrentFrameEnd(frameNo);
    }

    public void frameNoUpdate() {
        frameNo++;
    }

    public boolean isEnd() {
        return frames.isEnd();
    }

    public String getName() {
        return name;
    }

    public List<String> getFrameViews() {
        return frames.getFrameViews();
    }

    public void printFrameInfo() {
        System.out.print(frameNo + 1 + "프레임 투구 : ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
