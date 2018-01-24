package domain.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frames {
    private final List<Frame> frames = new ArrayList<>();

    void addFrame(Frame frame) {
        if (frame == null || frames.size() > 10) {
            throw new IllegalArgumentException();
        }
        frames.add(frame);
    }

    @Override
    public String toString() {
        if (frames.isEmpty()) {
            return "";
        }
        return frames.stream()
                     .map(Frame::toString)
                     .collect(Collectors.joining("|")) + "|";
    }
}
