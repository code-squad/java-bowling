package bowling.dto;

import java.util.Objects;

import static bowling.common.StaticVariables.FRAME_MAX_VALUE;

public class CurrentPlayerInfo {
    private String name;
    private int currentFrameNo;

    public CurrentPlayerInfo(String name, int currentFrameNo) {
        if(name == null || name.isEmpty() || currentFrameNo < 0 || currentFrameNo >= FRAME_MAX_VALUE)
            throw new IllegalArgumentException("invalid input for current player info");

        this.name = name;
        this.currentFrameNo = currentFrameNo;
    }

    public String getName() {
        return name;
    }

    public int getCurrentFrameNo() {
        return currentFrameNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentPlayerInfo that = (CurrentPlayerInfo) o;
        return currentFrameNo == that.currentFrameNo &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, currentFrameNo);
    }
}
