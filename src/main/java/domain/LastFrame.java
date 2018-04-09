package domain;

public class LastFrame implements Frame {

    private final int firstThrow;
    private final int secondThrow;
    private final int thirdThrow;

    public LastFrame(int firstThrow, int secondThrow, int thirdThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.thirdThrow = thirdThrow;
    }

    public boolean isStrike() {
        return firstThrow == MAX;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == MAX;
    }

    @Override
    public String toString() {
        if (isStrike()) {
            return ScoreMarker.markStrike() + ScoreMarker.markBonusNumber(thirdThrow);
        }
        if (isSpare()) {
            return ScoreMarker.markSpare(firstThrow) + ScoreMarker.markBonusNumber(thirdThrow);
        }
        return ScoreMarker.markNumbers(firstThrow, secondThrow) + ScoreMarker.markEmpty();
    }
}
