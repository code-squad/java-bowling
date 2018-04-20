package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrameData {

    private List<Frame> frames = new ArrayList<>();
    private Frame frame = NormalFrame.ofInComplete();

    public void play(int pin) {
        frame.updateFrameStatus(pin);
        checkCount(pin);
        if (frame.checkComplete()) {                  // 프레임이 완성 되었는지 확인하고 프레임을 생성
            createScore();
            frames.add(frame);
            frame = checkFrame();
        }
    }

    public boolean playLastFrame(int pin) {
        checkCount(pin);
        frame.updateFrameStatus(pin);
        frame.createScore(frames.get(numberOfFrames() - 1));
        return checkComplete();
    }

    public void createScore() {                     //스코어를 생성
        if (numberOfFrames() == 0) {
            frame.updateScore(frame.getStatus().getScore(0));
            return;
        }
        frame.createScore(frames.get(numberOfFrames() - 1));
    }

    public void checkCount(int pin) {
        for (int i = 0; i < frames.size(); i++) {
            addPinToBeforeFrame(i, pin);
        }
        for (Frame frame : frames) {
            minusCount(frame, pin);
        }
    }

    public void addPinToBeforeFrame(int i, int pin) { //스트라이크를 두번 연속 쳤으면 현재 친 핀의 개수를 더해준다.
        if (i != 0 && frames.get(i).getScore().isCountTwo() && frames.get(i - 1).getScore().isCountOne()) {
            frames.get(i).updateScore(frames.get(i).getScore().ofStayCount(pin));
        }
    }

    public void minusCount(Frame frame, int pin) { //Count의 값이 0이 아닌 것들을 계산해준다..
        if (!frame.getScore().canCalculateScore()) {
            frame.updateScore(frame.getScore().ofMinusCount(pin));
        }
    }

    public Frame checkFrame() {
        if (numberOfFrames() < 9) {
            return NormalFrame.ofInComplete();
        }
        return LastFrame.ofInComplete();
    }

    public boolean checkComplete() { //LastFrame이 끝났는지 체크하고 리스트에 추가
        if (frame.checkComplete()) {
            frames.add(frame);
            return true;
        }
        return false;
    }

    public int numberOfFrames() {
        return frames.size();
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(frames);
    }

    public Frame getFrame() {
        return frame;
    }
}
