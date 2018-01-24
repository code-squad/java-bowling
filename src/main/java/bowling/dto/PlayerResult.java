package bowling.dto;

import java.util.List;

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
}
