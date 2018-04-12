package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrameData {

    static final int LAST_FRAME = 9;

    private List<NomalFrame> frames = new ArrayList<>();
    private NomalFrame nomalFrame = new NomalFrame();
    private LastFrame lastFrame = new LastFrame();

    public void play(int pin) {
        nomalFrame.playOneBall(pin);
        if (nomalFrame.isStrike() || nomalFrame.isTwiceBall()) {
            frames.add(nomalFrame);
            nextFrame(frames.size());
        }
    }

    public boolean playLastFrame(int pin) {
        if (lastFrame.isNewFrame() || (lastFrame.isSecondNull() && !lastFrame.isStrike())) {
            lastFrame.playOneBall(pin);
        } else if (lastFrame.isStrike() || lastFrame.isSpare()) {
            lastFrame.playLastBall(pin);
        }
        return lastFrame.isLastBall();
    }

    public void nextFrame(int numberOfFrame) {
        if (numberOfFrame < LAST_FRAME) {
            nomalFrame = nomalFrame.next();
        }
    }

    public List<NomalFrame> getFrames() {
        return Collections.unmodifiableList(frames);
    }

    public NomalFrame getNomalFrame() {
        return nomalFrame;
    }

    public LastFrame getLastFrame() {
        return lastFrame;
    }

    public int numberOfFrame() {
        return frames.size() + 1;
    }
}
