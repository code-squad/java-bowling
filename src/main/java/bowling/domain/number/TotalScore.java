package bowling.domain.number;

public class TotalScore {
    private int total;

    public TotalScore(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return total == 0 ? "" : String.format("%3d",total);
    }
}