package domain.frame;

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
        pins.add(new Pin(num));
        leftNumber--;
        if (!status.isFinish()) {
            status = status.changeStatus(getSum(), leftNumber);
        }
    }

    public FrameScore get() {
        if (!isBonusFinish()) {
            // TODO : 예외처리 해줘야함(사용자정의 예외로 변경?)
            throw new RuntimeException("완료되지않은 프레임의 점수는 조회할 수 없습니다.");
        }
        return this;
    }

    public int getScore() {
        return getSum();
    }

    public String getPinMessage() {
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
