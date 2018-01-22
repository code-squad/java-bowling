package model;

public class Frame {
    private int round;
    protected RoundScore roundScore;
    private Frame nextFrame;

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
            if (this.nextFrame == null) {
                this.nextFrame = Frame.of(round + 1);
            }
            this.nextFrame.bowl(number);
        }
    }

    public boolean isFinal(){
        if (nextFrame != null) {
            return nextFrame.isFinal();
        }
        return false;
    }

    public static Frame of(int round ) {
        if (round == 10) return new FinalFrame();
        return new Frame(round);
    }

    public int getRoundScore() throws NullPointerException {
        int roundScoreSum = roundScore.getScoreSum();

        if (roundScore.isSpare()) {
            return roundScoreSum
                    + nextFrame.getPinCount(0);
        }

        if (roundScore.isStrike()) {
            if (nextFrame.getRoundScore() == 20) return 30;
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
