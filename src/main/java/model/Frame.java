package model;

public class Frame {
    protected int round;
    protected RoundScore roundScore;
    protected Frame nextFrame;

    public Frame(int round) {
        this.round = round;

        if (round < 10) {
            this.roundScore = new RoundScore(2);
            return;
        }

        this.roundScore = new RoundScore(3);
    }

    public void bowl(int number) {
        boolean success = roundScore.bowl(number);

        if (!success){
            if (this.nextFrame == null)
                this.nextFrame = new Frame(round + 1 );
            this.nextFrame.bowl(number);
        }

    }

    public int getRoundScore() {
        int roundScoreSum = roundScore.getScoreSum();

        if (roundScore.isSpare()) {
            return roundScoreSum
                    + nextFrame.getPinCount(0);
        }

        if (roundScore.isStrike()) {
            return roundScoreSum + getNextFrameScore();
        }

        return 0;
    }

    public Frame getNextFrame(){
        return nextFrame;
    }

    private int getPinCount(int index) {
        try {
            return roundScore.getPinCount(index);
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    private int getNextFrameScore() {
        return  nextFrame.getPinCount(0)
                + nextFrame.getPinCount(1)
                + nextFrame.getPinCount(2);
    }
}
