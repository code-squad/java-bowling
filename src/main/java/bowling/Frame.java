package bowling;

public class Frame {
    private Integer first;
    private Integer second;

    public void bowl(int throwPin) {
        if (isReady()) {
            this.first = throwPin;
        } else {
            this.second = throwPin;
        }
    }

    public String displayText() {
        if (isReady()) {
            return "";
        }
        if (isStrike()) {
            return "X";
        }
        if (isFirstBowl()) {
            return first + "";
        }
        if (isSpare()) {
            return first + "|/";
        }
        return first + "|" + second;
    }

    private boolean isSpare() {
        return first + second == 10;
    }

    private boolean isFirstBowl() {
        if (isReady()) {
            return false;
        }
        return !isStrike() && second == null;
    }

    private boolean isStrike() {
        return first == 10;
    }

    private boolean isReady() {
        return first == null;
    }

    public boolean isFinish() {
        if (isReady() || isFirstBowl()) {
            return false;
        }

        return true;
    }
}
