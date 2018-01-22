package model;

public class FinalFrame implements Frame {
    private FinalRoundScore finalRoundScore;

    public FinalFrame() {
        finalRoundScore = new FinalRoundScore();
    }

    @Override
    public void bowl(int number) {

    }

    @Override
    public int getPinCount(int index) {
        return 0;
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public String toString() {

    }
}
