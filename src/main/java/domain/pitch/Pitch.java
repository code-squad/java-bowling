package domain.pitch;

import domain.PlayStatus;
import domain.frame.Frame;

public class Pitch {
    private int pinCount;
    private int startPinCount;

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
        if(startPinCount == Frame.DEFAULT_START_PIN_COUNT) {
            if(pinCount == 0) {
                return PlayStatus.GUTTER;
            }
            
            if(isClear()) {
                return PlayStatus.STRIKE;
            }
            
            return PlayStatus.NONE;
        }
        
        if(pinCount == 0) {
            return PlayStatus.MISS;
        }
        
        if(isClear()) {
            return PlayStatus.SPARE;
        }
        
        return PlayStatus.OPEN;
    }
    
    public String getDisplayValue() {
        return String.format(getStatus().getDisplayFormat(), pinCount);
    }
}
