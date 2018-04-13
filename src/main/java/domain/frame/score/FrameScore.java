package domain.frame.score;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.status.FrameStatus;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class FrameScore {
    private FrameStatus status;
    private List<Pin> pins = new ArrayList<>();
    private int leftNumber;

    public FrameScore(int leftNumber) {
        status = FrameStatus.getInitStatus();
        this.leftNumber = leftNumber;
    }

    public void roll(int num) throws IllegalArgumentException {
        if (isOverRecordPin(num)) {
            throw new IllegalArgumentException("한 프레임에 정규 투구 기록할 수 있는 개수는 " + Pin.MAX + "개 입니다.");
        }
        pins.add(new Pin(num));
        leftNumber--;
        if (!status.isFinish()) {
            status = status.changeStatus(getSum(), leftNumber);
        }
    }

    public boolean isOverRecordPin(int num) {
        return !status.isFinish() && pins.size() != 0 && pins.get(0).isOverRecordPin(num);
    }

    public int getScore() {
        return getSum();
    }

    public String getScoreMessage() {
        if (!isBeforeBonusRoll()) {
            return status.convertScore(pins) + ScoreMessage.getMessage(ScoreMessage.MODIFIER) + makeBonusPinMessage();
        }
        return status.convertScore(pins);
    }

    private String makeBonusPinMessage() {
        if (status.isStrike()) {
            return pins.stream().filter(pin -> pins.indexOf(pin) >= Frame.REGULAR_COUNT - 1).map(pin -> ScoreMessage.convertMessage(pin.getNum())).collect(joining(ScoreMessage.getMessage(ScoreMessage.MODIFIER)));
        }

        return pins.stream().filter(pin -> pins.indexOf(pin) >= Frame.REGULAR_COUNT).map(pin -> ScoreMessage.convertMessage(pin.getNum())).collect(joining(ScoreMessage.getMessage(ScoreMessage.MODIFIER)));
    }

    private int getSum() {
        return pins.stream().mapToInt(Pin::getNum).sum();
    }

    public boolean isRegularFinish() {
        return status.isFinish();
    }

    public boolean isBonusFinish() {
        return leftNumber == 0;
    }

    public void increaseLeftCount() {
        if (status.isBonus()) {
            leftNumber += 1;
        }
    }

    public boolean isBeforeBonusRoll() {
        if (!status.isBonus()) {
            return true;
        }
        return status.isBonus() && status.isRightThrewNum(pins.size());
    }
}
