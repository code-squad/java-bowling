package domain.frame.result;

import domain.frame.Frame;
import domain.frame.result.score.FrameScore;

import java.util.HashMap;
import java.util.Map;

public class FrameResults {
    private Map<Frame, FrameResult> results = new HashMap<>();

    public void addMessage(Frame frame, String convertedScore) {
        if (!isExistRegisteredResult(frame)) {
            results.put(frame, new FrameResult());
        }

        if (convertedScore == null) {
            return;
        }
        FrameResult result = results.get(frame);
        result.addMessage(convertedScore);
    }

    public void addScore(Frame frame, FrameScore score) {
        if (score == null) {
            return;
        }

        if (!isExistRegisteredResult(frame)) {
            results.put(frame, new FrameResult());
        }
        FrameResult result = results.get(frame);
        result.addScore(score);
    }

    public String getMessage(Frame frame) {
        FrameResult result = results.get(frame);
        return result.getMessage();
    }

    public FrameScore getScore(Frame frame) throws NullPointerException {
        try {
            FrameResult result = results.get(frame);
            return result.getScore();
        } catch (NullPointerException e) {
            throw new NullPointerException("결과값 null에 대해서 뷰가 처리해야합니다.");
        }
    }

    public boolean isExistRegisteredResult(Frame frame) {
        return results.containsKey(frame);
    }
}
