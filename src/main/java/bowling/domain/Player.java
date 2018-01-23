package bowling.domain;

public class Player {
    private Name name;
    private ScoreSheet scoreSheet;

    public Player(Name name, ScoreSheet scoreSheet) {
        this.name = name;
        this.scoreSheet = scoreSheet;
    }

    public void roll() {
        Roll roll = new Roll();
    }

    public void roll(int pinCount) {
        Roll roll = new Roll(pinCount);
    }

    @Override
    public String toString() {
        return name.toString()+scoreSheet.toString();
    }
}
