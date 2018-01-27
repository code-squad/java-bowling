package bowling.domain;

import bowling.dto.CurrentPlayerInfo;
import bowling.dto.PlayerResult;

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
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("invalid name");
    }

    public void rollBowlingBall(int pin) {
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

    public CurrentPlayerInfo createPlayerInfo() {
        return new CurrentPlayerInfo(name, frameNo);
    }

    public PlayerResult getPlayerResult() {
        return new PlayerResult(name, frames.getFrameViews(), frames.getScoreViews());
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
