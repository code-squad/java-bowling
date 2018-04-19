package domain.pitch;

import domain.PlayStatus;

import java.util.Optional;

public class Pitch {
    private static final int DEFAULT_START_PIN_COUNT = 10;
    
    private Integer pinCount;
    private Integer startPinCount;
    
    public Pitch(int pinCount) {
        if (DEFAULT_START_PIN_COUNT < pinCount) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.pinCount = pinCount;
    }

    public Pitch(int startPinCount, int pinCount) {
        if (startPinCount < pinCount) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.startPinCount = startPinCount;
        this.pinCount = pinCount;
    }
    
    public boolean isClear() {
        if(isRefreshPitch()) {
            return pinCount.equals(DEFAULT_START_PIN_COUNT);
        }
        return pinCount.equals(startPinCount);
    }
    
    public int getRemainPinCount() {
        if(isRefreshPitch()) {
            return DEFAULT_START_PIN_COUNT - pinCount;
        }
        return startPinCount - pinCount;
    }

    public PlayStatus getStatus() {
        if (pinCount == 0) {
            return isRefreshPitch() ? PlayStatus.GUTTER : PlayStatus.MISS;
        }
        
        if (isClear()) {
            return isRefreshPitch() ? PlayStatus.STRIKE : PlayStatus.SPARE;
        }
        
        return isRefreshPitch() ? PlayStatus.NONE : PlayStatus.OPEN;
    }
    
    public String getDisplayValue() {
        return String.format(getStatus().getDisplayFormat(), pinCount);
    }
    
    private boolean isRefreshPitch() {
        return startPinCount == null;
    }
}
