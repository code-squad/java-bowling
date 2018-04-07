package domain.frame.result;

import domain.frame.Frame;

import java.util.HashMap;
import java.util.Map;

public class FrameResults {
    private Map<Frame, FrameResult> results = new HashMap<>();

    public void addResult(Frame frame, FrameResult result) {
        if (results.containsKey(frame)) {
            results.replace(frame, result);
            return;
        }
        results.put(frame, result);
    }

    public int getSavedSize() {
        return results.size();
    }
}
