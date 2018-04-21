package domain.pitch;

import domain.PlayStatus;

public class Pitch {
    private static final int DEFAULT_START_PIN_COUNT = 10;
    
    private Integer pin;
    private Integer leftPin;
    
    public Pitch(int pin) {
        if (DEFAULT_START_PIN_COUNT < pin) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.pin = pin;
    }

    public Pitch(int leftPin, int pin) {
        if (leftPin < pin) {
            throw new IllegalArgumentException("쓰러뜨린 핀수는 투구 시작 전 남아있는 핀수보다 작거나 같아야 한다.");
        }
        this.leftPin = leftPin;
        this.pin = pin;
    }
    
    public boolean isClear() {
        if(isNewStart()) {
            return pin.equals(DEFAULT_START_PIN_COUNT);
        }
        return pin.equals(leftPin);
    }

    public Integer getPin() {
        return pin;
    }
    
    public int getLeftPin() {
        if(isNewStart()) {
            return DEFAULT_START_PIN_COUNT - pin;
        }
        return leftPin - pin;
    }

    public PlayStatus getStatus() {
        if (pin == 0) {
            return isNewStart() ? PlayStatus.GUTTER : PlayStatus.MISS;
        }
        
        if (isClear()) {
            return isNewStart() ? PlayStatus.STRIKE : PlayStatus.SPARE;
        }
        
        return isNewStart() ? PlayStatus.NONE : PlayStatus.OPEN;
    }
    
    public String getDisplayValue() {
        return String.format(getStatus().getDisplayFormat(), pin);
    }
    
    private boolean isNewStart() {
        return leftPin == null;
    }
}
