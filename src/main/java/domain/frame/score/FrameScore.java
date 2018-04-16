package domain.frame.score;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
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
            throw new IllegalArgumentException(Pin.MAX + "개 까지만 입력가능합니다.");
        }
        recordRollPin(num);
        changeFrameStatus();
    }

    private void recordRollPin(int num) {
        if (!isBonusFinish()) {
            pins.add(new Pin(num));
            leftNumber--;
            /*
                -> 정규투구 스트라이크일 때만 다름 (X), 상태값으로 알 수 있잖아 저장 인덱스 몇에 끝났는지
                -> 저장될 때 스트라이크고, 마지막 프레임이라면 첫번째 보너스 투구가 10점이 아니라면
                -> 아니면 최근 핀을 %10 하고, 지금 점수랑 합쳤을 때 10점이 넘는다면 저장되지못하도록 팅구기



             */
        }
    }

    /*private boolean isOverRecordPin(int num) {
        try {
            Pin pin = pins.get(convertThrowNumToIdx(pins.size()));
            return (pin.getNum() % 10) + num > Pin.MAX;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private int convertThrowNumToIdx(int throwNum) {
        return throwNum -1;
    } */

    private void changeFrameStatus() {
        if (!status.isFinish()) {
            status = status.changeStatus(get(), leftNumber);
        }
    }

    public boolean isOverRecordPin(int num) {
        return !status.isFinish() && pins.size() != 0 && pins.get(0).isOverRecordPin(num);
    }

    public FrameScore getScore() throws CannotCalcException {
        if (!isBonusFinish()) {
            throw new CannotCalcException("종료되지않은 프레임의 합계점수는 구할 수 없습니다.");
        }
        return this;
    }

    public String makeScoreMessage(Frame frame) {
        if (frame.isLast() && !isBeforeBonusRoll()) {
            return status.convertScore(pins) + ScoreMessage.getMessage(ScoreMessage.MODIFIER) + makeBonusPinMessage();
        }
        return status.convertScore(pins);
    }

    /* 여기는 수정 가능성이 있음 */
    private String makeBonusPinMessage() {
        if (status.isStrike()) {
            return pins.stream().filter(pin -> pins.indexOf(pin) >= Frame.REGULAR_COUNT - 1).map(pin -> ScoreMessage.convertMessage(pin.getNum())).collect(joining(ScoreMessage.getMessage(ScoreMessage.MODIFIER)));
        }

        return pins.stream().filter(pin -> pins.indexOf(pin) >= Frame.REGULAR_COUNT).map(pin -> ScoreMessage.convertMessage(pin.getNum())).collect(joining(ScoreMessage.getMessage(ScoreMessage.MODIFIER)));
    }

    public int get() {
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

    public void addBonusPinNum(Frame nextFrame) {
        List<Integer> bonusPins = nextFrame.getRecentlyPinNums(leftNumber);
        if (bonusPins.size() == leftNumber) {
            bonusPins.forEach(this::roll);
        }
    }

    public boolean isPossibleGettingPins(Frame nextFrame, int amount) {
        if (pins.size() == amount || checkNextFrame(nextFrame, amount)) {
            return true;
        }
        return false;
    }

    private boolean checkNextFrame(Frame nextFrame, int amount) {
        if (nextFrame == null) {
            return false;
        }

        int diffNum = amount - pins.size();
        return nextFrame.haveTried(diffNum);
    }

    public boolean isWithinRollNum(int rollNum) {
        return pins.size() >= rollNum;
    }

    public List<Integer> getBonusPins(Frame nextFrame, int amount) {
        List<Integer> bonusPins = new ArrayList<>();
        for (int i = 0; i < pins.size(); i++) {
            Pin pin = pins.get(i);
            bonusPins.add(pin.getNum());
        }
        if (bonusPins.size() != amount) {
            int diffNum = amount - bonusPins.size();
            bonusPins.addAll(nextFrame.getPins(diffNum));
        }
        return bonusPins;
    }

    public List<Integer> getPins(int amount) {
        List<Integer> pinNums = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Pin pin = pins.get(0);
            pinNums.add(pin.getNum());
        }
        return pinNums;
    }
}
