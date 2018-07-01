package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int GAME_END_FRAME = 10;
    private List<Frame> elements = new ArrayList<>();

    void add(int frameId) {
        add(new Frame(frameId));
    }

    private void add(Frame frame) {
        elements.add(frame);
    }

    void roll(int pins) {
        if (!canRoll()) {
            addNextFrame();
        }
        currentFrame().roll(pins);
    }

    void addNextFrame() {
        elements.add(new Frame(currentFrame().getFrameId() + 1));
    }

    Frame currentFrame() {
        return elements.get(elements.size() - 1);
    }

    int rollFrameId() {
        return canRoll() ? elements.get(elements.size() - 1).getFrameId() : elements.size() + 1;
    }

    List<Frame> getAll() {
        return elements;
    }

    boolean canRoll() {
        return currentFrame().canRoll();
    }

    boolean isAllFramesEnd() {
        if (GAME_END_FRAME > currentFrame().getFrameId()) {
            return false;
        }

        // FIXME 10프레임에서 모든 핀을 쓰러뜨리면 한번 더 할 수 있다는 정책이 좀 더 명시적으로 드러나야 할 필요..
        if (currentFrame().isKnockDownAllFrame()) {
            return false;
        }

        return !currentFrame().canRoll();
    }
}
