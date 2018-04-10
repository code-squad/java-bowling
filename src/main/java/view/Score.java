package view;

import domain.Frame;
import domain.LastFrame;
import domain.NormalFrame;

import java.util.ArrayList;
import java.util.List;

import static view.ScoreMarker.*;
import static view.Formatter.*;

public class Score {
    private final String name;
    private List<Frame> frames;

    public Score(String name) {
        this.name = name;
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        this.frames = frames;
    }

    public boolean updateScore(int throwScore, int throwCount) {
        int frameNumber = throwCount / 2;
        int lastFrame = frames.size() - 1;
        if (frameNumber < lastFrame) {
            frames.get(throwCount / 2).updateFrame(throwScore);
            return true;
        }
        frames.get(lastFrame).updateFrame(throwScore);
        return true;
    }

    public boolean isBonus() {
        Frame lastFrame = frames.get(9);
        if (lastFrame.isStrike() || lastFrame.isSpare()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(markSeparator()); // 이름
        builder.append(formatFrame(name));

        for (Frame frame : frames) { //프레임 스코어
            builder.append(markSeparator());
            builder.append(formatFrame(frame.toString()));
            builder.append(markSeparator());
        }
        return builder.toString();
    }
}