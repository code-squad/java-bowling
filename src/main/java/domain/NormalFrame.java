package domain;

import state.Ready;
import state.State;

public class NormalFrame extends Frame {
    private static final String EMPTY = "";
    private static final int MAX_FRAME_NO = 10;

    private final int no;
    //    private Score score;
    private Frame next;
    private State state = new Ready(); // strike;

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


    public NormalFrame(int no) {
        super(no);
        this.no = no;
    }

//    public NormalFrame(int no, Score beforeScore) {
//        super(no, beforeScore);
//    }

//    public NormalFrame(int no, Score beforeScore) {
//        super(no);
//    }

    public State bowl(int falledPins) {
        return state = updateState(falledPins);
//        if (isEnd()) {
//            score = createScore();
//        }
    }

    public State updateState(int throwing) {
        return state.throwing(throwing);
    }

    @Override
    public Frame next() {
        if (no == MAX_FRAME_NO - 1) {
            return new LastFrame(no + 1);
        }
        return next = new NormalFrame(no + 1);
    }

    @Override
    public boolean isLastFrame() {
        return false;
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
    public Score createScore(int beforeScore) {
        return state.getScore().calculateScore(beforeScore);
    }

    @Override
    public int getScore(int beforeScore) {
        Score score = createScore(beforeScore);
        if (score.canCalculateScore()) {
            return score.getScore();
        }
        if (next != null) {
            return next.calculateAdditionalScore(score);
        }
        return 0;
    }

    @Override
    public int calculateAdditionalScore(Score beforeScore) {
        beforeScore = state.updateScore(beforeScore);
        if (beforeScore.canCalculateScore()) {
            return beforeScore.getScore();
        }
        if (next != null) {
            return next.calculateAdditionalScore(beforeScore);
        }
        return 0;
    }
}