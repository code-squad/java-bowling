package domain.frame;

import domain.frame.result.ScoreMessage;
import domain.frame.status.FrameStatus;

import java.util.ArrayList;
import java.util.List;

public class FrameScore {
    private FrameStatus status;
    private List<Pin> pins = new ArrayList<>();
    private int leftNumber;

    public FrameScore(int leftNumber) {
        status = FrameStatus.getInitStatus();
        this.leftNumber = leftNumber;
    }

    public void roll(int num) throws IllegalArgumentException {
        pins.add(new Pin(num));
        leftNumber--;
        status = status.changeStatus(getSum(), leftNumber);
    }

    public FrameScore getScore() {
        if (!isBonusFinish()) {
            throw new RuntimeException("완료되지않은 프레임의 점수는 조회할 수 없습니다."); //예외처리 해줘야함
        }
        return this;
    }

    public String getLatestSavedPinMessage() {
        Pin latestPin = pins.get(pins.size() - 1);
        if (status.isBonus()) {
            return ScoreMessage.convertMessage(latestPin.getNum());
        }
        return status.convertScore(latestPin.getNum());
    }

    private int getSum() {
        return pins.stream().mapToInt(Pin::getNum).sum();
    }

    public boolean isRegularFinish() {
        return status.isFinish();
    }

    public boolean isBonusFinish() { // 이것도 있고 보너스도 있고
        return leftNumber == 0;
    }

    public void increaseLeftCount() {
        if (status.isBonus()) {
            leftNumber += 1;
        }
    }

    public boolean isBeforeBonusRoll() {
        return status.isBonus() && leftNumber <= Frame.REGULAR_COUNT;
    }
}
