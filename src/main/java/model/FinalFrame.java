package model;

public class FinalFrame extends Frame{
    private int[] frameScores;

    public FinalFrame() {
        this.frameScores = new int[3];
    }

    public void setBallThree(int number) {

        frameScores[2] = number;
    }

    public boolean isAbleToPlay() {

        if (super.isStrike()) return true;
        if (super.isSpare()) return true;

        return false;
    }

}
