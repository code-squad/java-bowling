package bowling.dto;

import java.util.List;
import java.util.Objects;

public class PlayerResult {
    private String name;
    private List<String> frameViews;

    public PlayerResult(String name, List<String> frameViews) {
        if(frameViews == null || frameViews.isEmpty())
            throw new IllegalArgumentException("not enough value");

        this.name = name;
        this.frameViews = frameViews;
    }

    public String getName() {
        return name;
    }

    public List<String> getFrameViews() {
        return frameViews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerResult that = (PlayerResult) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(frameViews, that.frameViews);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, frameViews);
    }
}
