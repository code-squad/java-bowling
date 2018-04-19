package domain.pitch;

import domain.PlayStatus;

public class Pitch {
    private static final int DEFAULT_START_PIN_COUNT = 10;
    
    private Integer pinCount;
    private Integer beforeRemainedPinCount;
    
    public Pitch(int pinCount) {
        if (DEFAULT_START_PIN_COUNT < pinCount) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.pinCount = pinCount;
    }

    public Pitch(int beforeRemainedPinCount, int pinCount) {
        if (beforeRemainedPinCount < pinCount) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.beforeRemainedPinCount = beforeRemainedPinCount;
        this.pinCount = pinCount;
    }
    
    public boolean isClear() {
        if(isNewStartPitch()) {
            return pinCount.equals(DEFAULT_START_PIN_COUNT);
        }
        return pinCount.equals(beforeRemainedPinCount);
    }

    public Integer getPinCount() {
        return pinCount;
    }
    
    public int getRemainPinCount() {
        if(isNewStartPitch()) {
            return DEFAULT_START_PIN_COUNT - pinCount;
        }
        return beforeRemainedPinCount - pinCount;
    }

    public PlayStatus getStatus() {
        if (pinCount == 0) {
            return isNewStartPitch() ? PlayStatus.GUTTER : PlayStatus.MISS;
        }
        
        if (isClear()) {
            return isNewStartPitch() ? PlayStatus.STRIKE : PlayStatus.SPARE;
        }
        
        return isNewStartPitch() ? PlayStatus.NONE : PlayStatus.OPEN;
    }
    
    public String getDisplayValue() {
        return String.format(getStatus().getDisplayFormat(), pinCount);
    }
    
    private boolean isNewStartPitch() {
        return beforeRemainedPinCount == null;
    }
}
