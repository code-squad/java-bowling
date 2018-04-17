package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scores {

    private List<Score> scores = new ArrayList<>();

    public void createScore(FrameStatus frameStatus) {
        Score score;
        if (scores.size() == 0) {
            score = Score.of(frameStatus.pinOfFrame(), frameStatus.getCount());
            scores.add(score);
            return;
        }
        score = Score.of(scores.get(scores.size() - 1).getScore() + frameStatus.pinOfFrame(), frameStatus.getCount());
        scores.add(score);
    }

    public void createTwoScore(LastFrame lastFrame, boolean lastCheck) {
        if (lastCheck) {
            Score score = Score.of(scores.get(scores.size() - 1).getScore() + lastFrame.getFrameStatus().pinOfFrame(), lastFrame.getFrameStatus().getCount());
            scores.add(score);
        }
    }

    public void createThreeScore(LastFrame lastFrame, int pin) {
        Score score = Score.of(scores.get(scores.size() - 1).getScore() + lastFrame.getFrameStatus().pinOfFrame() + pin, lastFrame.getFrameStatus().getCount());
        scores.add(score);
    }

    public void checkCount(int pin) {
        for (int i = 0; i < scores.size(); i++) {
            minusCount(i, pin);
        }
    }

    public void minusCount(int i, int pin) { //Count의 값이 0이 아닌 것들을 계산해준다..
        if (!scores.get(i).canCalculateScore()) {
            addPinToBeforeFrame(i, pin);
            scores.set(i, scores.get(i).ofMinusCount(pin));
        }
    }

    public void addPinToBeforeFrame(int i, int pin) {
        if (i != 0 && scores.get(i).canCalculateStrike()) {      //전에 스트라이크를 쳤으면 현재 친 핀의 개수를 더해준다.
            scores.set(i, scores.get(i).ofStayCount(pin));
        }
    }

    public List<Score> getScores() {
        return Collections.unmodifiableList(scores);
    }
}
