package domain.frame.result;

import domain.frame.Frame;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrameResults {
    private Map<Frame, FrameResult> results = new LinkedHashMap<>();

    public void addResult(Frame frame, String convertedScore) {
        if (!results.containsKey(frame)) {
            results.put(frame, new FrameResult());
        }
        FrameResult result = results.get(frame);
        result.addResultEachThrow(convertedScore);
    }

    public int getSavedSize() {
        return results.size();
    }

    /* 추가될 때마다 꺼내어 갈 수 있도록 외부 인터페이스 만들기 */
}
