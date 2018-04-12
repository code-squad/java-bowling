package domain.frame.result;

import domain.frame.Frames;

import java.util.ArrayList;
import java.util.List;

public class FrameResults {
    private List<FrameResult> results = new ArrayList<>();

    public void addResult(int frameIdx, String convertedScore) {
        if (!isExistFrameResult(frameIdx)) {
            results.add(new FrameResult());
        }
        FrameResult result = results.get(frameIdx);
        result.add(convertedScore);
    }

    public boolean isExistFrameResult(int frameIdx) {
        try {
            results.get(frameIdx);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getSavedSize() {
        return results.size();
    }

    public int getMaxSaveSize() {
        return Frames.LIMIT;
    }

    public String getFrameResultMessage(int frameIdx) {
        try {
            FrameResult frameResult = results.get(frameIdx);
            return frameResult.toString();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
