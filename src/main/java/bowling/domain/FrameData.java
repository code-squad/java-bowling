package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrameData {

    private List<Frame> frames = new ArrayList<>();
    private Scores scores = new Scores();
    private LastFrame lastFrame;
    private InCompleteFrame inCompleteFrame = new InCompleteFrame();

    public void play(int pin) {
        inCompleteFrame.play(pin);
        scores.checkCount(pin);
        if (inCompleteFrame.checkComplete()) {                  // 프레임이 완성 되었는지 확인하고 프레임을 생성
            FrameStatus frameStatus = inCompleteFrame.check();
            scores.createScore(frameStatus);
            frames.add(new Frame(frameStatus));
            inCompleteFrame = new InCompleteFrame();
        }
    }

    public boolean playLastFrame(int pin) {
        scores.checkCount(pin);
        if (lastFrame == null) {
            makeLastFrame(pin);
            scores.createTwoScore(lastFrame, isLastBall());
            return isLastBall();
        }
        lastFrame.playBonusBall(pin);
        scores.createThreeScore(lastFrame, pin);
        return true;
    }

    private void makeLastFrame(int pin) {                    //마지막 프레임을 생성한다.
        inCompleteFrame.play(pin);
        if (inCompleteFrame.checkLastFrameComplete()) {
            FrameStatus frameStatus = inCompleteFrame.check();
            lastFrame = new LastFrame(frameStatus);
        }
    }

    private boolean isLastBall() {
        if (lastFrame == null) {
            return false;
        }
        return lastFrame.isLastBall();
    }

    public int numberOfFrames() {
        return frames.size();
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(frames);
    }

    public LastFrame getLastFrame() {
        return lastFrame;
    }

    public InCompleteFrame getInCompleteFrame() {
        return inCompleteFrame;
    }

    public Scores getScores() {
        return scores;
    }
}
