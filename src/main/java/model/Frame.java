package model;

public class Frame {
    private int[] frameScores;

    public Frame() {
        frameScores = new int[2];
    }

    public boolean isValidNumber(int number) {
        if ((frameScores[0] + number) > 10 || number < 0) return false;
        return true;
    }


    public void setBallOne(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException();
        }
        frameScores[0] = number;
    }

    public boolean isStrike() {
        return frameScores[0] == 10;
    }

    public void setBallTwo(int number) {
        if (!isValidNumber(number))
            throw new IllegalArgumentException();

        frameScores[1] = number;
    }

    public boolean isSpare() {
        return (frameScores[0] + frameScores[1]) == 10;
    }

    @Override
    public String toString() {
        if (isStrike()) return "X  ";
        if (isSpare()) return frameScores[0] + "|/";
        return frameScores[0] + "|" + frameScores[1];
    }
}
