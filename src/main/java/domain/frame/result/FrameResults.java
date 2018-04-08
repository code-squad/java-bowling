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
        result.addResultEachThrow(convertedScore);
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
        return Frames.LIMIT_NUM;
    }
    /* 추가될 때마다 꺼내어 갈 수 있도록 외부 인터페이스 만들기 */
}
