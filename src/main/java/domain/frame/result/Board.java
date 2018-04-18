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

    public List<String> getResultMessage() {
        List<String> resultMessages = new ArrayList<>();
        for (FrameResult result : results) {
            resultMessages.add(result.getMessage());
        }
        return resultMessages;
    }

    public List<Integer> getResultScore() {
        List<Integer> resultScores = new ArrayList<>();
        for (FrameResult result : results) {
            resultScores.add(result.getScore());
        }
        return resultScores;
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
