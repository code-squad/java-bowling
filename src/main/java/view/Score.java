package view;

import domain.Frame;

import java.util.List;

import static view.ScoreMarker.*;
import static view.Formatter.*;

public class Score {
    private final String name;
    private List<Frame> frames;

    public Score(String name, List<Frame> frames) {
        this.name = name;
        this.frames = frames;
    }

    public void updateScore(Frame frame) {
        frames.add(frame);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(markSeparator()); // 이름
        builder.append(formatFrame(name));

        for (Frame frame : frames) { //프레임 스코어
            builder.append(markSeparator());
            builder.append(frame);
            builder.append(markSeparator());
        }
        return builder.toString();
    }
}
