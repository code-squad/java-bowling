package domain;

public class LastFrame extends Frame {
    private final int thirdThrow;

    public LastFrame(int firstThrow, int secondThrow, int thirdThrow) {
        super(firstThrow, secondThrow);
        this.thirdThrow = thirdThrow;
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
