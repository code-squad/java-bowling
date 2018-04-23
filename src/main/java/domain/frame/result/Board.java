package domain.frame.result;

import domain.frame.Frame;

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

    public String getFrameMessage(int frameNum) {
        int frameIdx = convertToFrameIdx(frameNum);
        return results.get(frameIdx).getMessage();
    }

    public int getFrameTotalScore(int frameNum) {
        int frameIdx = convertToFrameIdx(frameNum);
        int frameScore = results.get(frameIdx).getScore();
        if (frameScore == Frame.CANNOT_CALC_SCORE_STATE) {
            return frameScore;
        }

        for (int i = frameIdx - 1; i >= 0; i--) {
            frameScore += results.get(i).getScore();
        }
        return frameScore;
    }

    private int convertToFrameIdx(int frameNum) {
        return frameNum - 1;
    }

    public int getCurrentFrameNum() {
        return results.size();
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
