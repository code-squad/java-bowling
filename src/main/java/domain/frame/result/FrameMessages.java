package domain.frame.result;

import java.util.ArrayList;
import java.util.List;

//여기 List<FrameScore> 까지 합해서 FrameResult로 생길 가능성O
public class FrameMessages {
    private List<FrameMessage> messages = new ArrayList<>();

    public void addFrameMessage(int frameIdx, String convertedScore) {
        if (!isExistRegisteredFrameMessage(frameIdx)) {
            messages.add(new FrameMessage());
        }
        FrameMessage result = messages.get(frameIdx);
        result.add(convertedScore);
    }

    private boolean isExistRegisteredFrameMessage(int frameIdx) {
        try {
            messages.get(frameIdx);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getRegisteredSize() {
        return messages.size();
    }

    public String getFrameResultMessage(int frameIdx) {
        try {
            FrameMessage frameMessage = messages.get(frameIdx);
            return frameMessage.toString();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
