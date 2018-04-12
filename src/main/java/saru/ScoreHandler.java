package saru;

import java.util.ArrayList;
import java.util.List;

public class ScoreHandler {
    private List<Frame> frames = new ArrayList<>();

    // TODO 할당?
    private ScoreHandler() {
        // empty
    }

    public static ScoreHandler of() {
        return new ScoreHandler();
    }

    // TODO paginate
    public void pageinate() {
        if (frames.get(getNowPageIndex()).checkFull()) {
            frames.add(Frame.of(2));
        }
    }

    // TODO 현재 페이지 인덱스?
    public int getNowPageIndex() {
        return frames.size() - 1;
    }

    public void init() {
        frames.add(Frame.of(2));
    }

    // TODO 메시지로 못하나?
    Frame getNowFrame() {
        return frames.get(frames.size() - 1);
    }
}
