package domain.frame.result;

import java.util.List;

public class Board {
    public static final int LIMIT = 10;
    private List<FrameResult> results;

    public Board(List<FrameResult> results) {
        this.results = results;
    }

    public static boolean isLimit(int frameNum) {
        return LIMIT == frameNum;
    }
}
