package domain;

import state.Ready;
import state.State;

public class NormalFrame extends Frame {
    private static final String EMPTY = "";
    private static final int MAX_FRAME_NO = 10;
    private final int no;
    //    private Score score;
    private int score;
    private Frame next;
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

    private State state = new Ready(); // strike;

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

    public void throwing(int throwing) {
        state = updateState(throwing);
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
    public boolean isEnd() {
        return state.isEnd();
    }

    @Override
    public String printState() {
        return state.printState();
    }

    @Override
    public String printScore() {
        if (!isEnd()) {
            return EMPTY;
        }
        score = getScore();
        if (score == 0) {
            return "";
        }
        return String.valueOf(score);
    }

    @Override
    public Score createScore() {
        return state.getScore().calculateScore(score);
    }

    @Override
    public int getScore() {
        Score score = createScore();
        if (score.canCalculateScore()) {
            return score.getScore();
        }
        return next.calculateAdditionalScore(score);
    }

    @Override
    public int calculateAdditionalScore(Score beforeScore) {
        beforeScore = state.updateScore(beforeScore);
        if (next != null) {
            return score = getScore();
        }
        return 0;  // 아직 하나 더 와야 하는데 여기서 에러발생
    }
}