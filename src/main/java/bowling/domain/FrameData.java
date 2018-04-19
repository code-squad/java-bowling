package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrameData {

    private List<NormalFrame> frames = new ArrayList<>();
    private LastFrame lastFrame = new LastFrame(InComplete.of(null,null));
    private InCompleteFrame inCompleteFrame = new InCompleteFrame();
    private NormalFrame frame = NormalFrame.ofInComplete();

    public void play(int pin) {
        frame.updateFrameStatus(pin);
        checkCount(pin);
        if (frame.checkComplete()) {                  // 프레임이 완성 되었는지 확인하고 프레임을 생성
            createScore();
            frames.add(frame);
            frame = NormalFrame.ofInComplete();
        }
    }

    public boolean playLastFrame(int pin) {
        checkCount(pin);
        if (!lastFrame.checkComplete()) {
            lastFrame.updateFrameStatus(pin);
            lastFrame.createTwoScore(frames.get(numberOfFrames() - 1));
            return lastFrame.isLastBall();
        }
        lastFrame.playBonusBall(pin);
        lastFrame.createThreeScore(frames.get(numberOfFrames() - 1), pin);
        return true;
    }

    public void createScore() {
        if (numberOfFrames() == 0) {
            frame.createScoreZero();
            return;
        }
        frame.createScore(frames.get(numberOfFrames() - 1));
    }

    public void checkCount(int pin) {
        for (NormalFrame frame : frames) {
            minusCount(frame, pin);
        }
    }

    public void minusCount(NormalFrame frame, int pin) { //Count의 값이 0이 아닌 것들을 계산해준다..
        if (!frame.getScore().canCalculateScore()) {
            addPinToBeforeFrame(frame, pin);
            frame.updateScore(frame.getScore().ofMinusCount(pin));
        }
    }

    public void addPinToBeforeFrame(NormalFrame frame, int pin) {
        if (frames.indexOf(frame) != 0 && frame.getScore().canCalculateStrike()) {      //전에 스트라이크를 쳤으면 현재 친 핀의 개수를 더해준다.
            frame.updateScore(frame.getScore().ofStayCount(pin));
        }
    }

    public int numberOfFrames() {
        return frames.size();
    }

    public List<NormalFrame> getFrames() {
        return Collections.unmodifiableList(frames);
    }

    public LastFrame getLastFrame() {
        return lastFrame;
    }

    public InCompleteFrame getInCompleteFrame() {
        return inCompleteFrame;
    }
}
