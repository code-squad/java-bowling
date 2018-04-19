package domain.pitch;

import domain.PlayStatus;

public class Pitch {
    private static final int DEFAULT_START_PIN_COUNT = 10;
    
    private int pinCount;
    private int startPinCount;
    
    public Pitch(int pinCount) {
        if (DEFAULT_START_PIN_COUNT < pinCount) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.startPinCount = DEFAULT_START_PIN_COUNT;
        this.pinCount = pinCount;
    }

    public Pitch(int startPinCount, int pinCount) {
        if (startPinCount < pinCount) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.startPinCount = startPinCount;
        this.pinCount = pinCount;
    }
    
    public int getRemainPinCount() {
        return startPinCount - pinCount;
    }

    public boolean isClear() {
        return startPinCount - pinCount == 0;
    }

    public PlayStatus getStatus() {
        if(pinCount == 0) {
            return startPinCount == DEFAULT_START_PIN_COUNT ? PlayStatus.GUTTER : PlayStatus.MISS;
        }
        
        if(isClear()) {
            return startPinCount == DEFAULT_START_PIN_COUNT ? PlayStatus.STRIKE : PlayStatus.SPARE;
        }
        
        return startPinCount == DEFAULT_START_PIN_COUNT ? PlayStatus.NONE : PlayStatus.OPEN;
    }
    
    public String getDisplayValue() {
        return String.format(getStatus().getDisplayFormat(), pinCount);
    }
}
