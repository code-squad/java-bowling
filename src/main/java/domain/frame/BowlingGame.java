package domain.frame;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    private final List<Frame> frames;

    private final String playerName;

    public BowlingGame(String playerName) {
        if (StringUtils.isEmpty(playerName) || playerName.length() != 3) {
            throw new IllegalArgumentException();
        }
        this.playerName = playerName;
        this.frames = new ArrayList<>();
    }

    public void addFrame(Frame frame) {
        if (frame == null || frames.size() > 12) {
            throw new IllegalArgumentException();
        }
        frames.add(frame);
    }

    @Override
    public String toString() {
        return "| " + playerName + "  |" + framesToString() + remainFrames();
    }

    private String framesToString() {
        if (frames.size() == 0) {
            return "";
        }
        return frames.stream()
                     .map(Frame::toString)
                     .collect(Collectors.joining("|")) + "|";
    }

    private String remainFrames() {
        int remain = 10 - frames.size();
        if (remain > 0) {
            return Strings.repeat("    |", remain);
        }
        return "";
    }

    public int size() {
        return frames.size();
    }
}
