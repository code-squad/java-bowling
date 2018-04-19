package domain;

import state.*;

public class NormalFrame extends Frame {
    private Score score;
//    private Score beforeScore;
//
//    직전스코어계산() {
//        strike : beforeScore.bowl(firstPins+secondPins);
//        spare : beforeScore.bowl(firstPins);
//    }
//
//    전전스코어계산(Sore bbefore) {
//        bbefore.bowl(firstPins);
//    }

    private State state = new Ready();

    public NormalFrame(int no) {
        super(no, null);
    }

    public NormalFrame(int no, Score beforeScore) {
        super(no, beforeScore);
    }

    public void throwing(int throwing) {
        state = updateState(throwing);
    }

    public State updateState(int throwing) {
        return state.throwing(throwing);
    }

    @Override
    public boolean isEnd() {
        return state.isEnd();
    }

    @Override
    public String printState() {
        return state.printState();
    }

    @Override
    public String printScore() {
        return String.valueOf(score);
    }

    @Override
    public Score createScore() {
            return score = state.getScore();
    }
}
