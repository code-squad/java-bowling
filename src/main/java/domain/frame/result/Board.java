package domain.frame.result;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int LIMIT = 10;
    private List<FrameResult> results = new ArrayList<>();

    public static boolean isLimit(int frameNum) {
        return LIMIT == frameNum;
    }

    public void addResult(FrameResult result) {
        results.add(result);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (FrameResult result : results) {
            builder.append(result.getMessage()).append(", ").append(result.getScore()).append("\n");
        }
        return builder.toString();
    }
}
