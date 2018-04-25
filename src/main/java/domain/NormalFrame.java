package domain;

import state.Ready;
import state.State;

public class NormalFrame extends Frame {
    private static final String EMPTY = "";
    private static final int MAX_FRAME_NO = 10;

    private final int no;
    private Frame next;
    private State state = new Ready(); // strike;

    public NormalFrame(int no) {
        super(no);
        this.no = no;
    }

    @Override
    public State bowl(Pins falledPins) {
        return state = state.bowl(falledPins);
    }

    @Override
    public Frame next() {
        if (no == MAX_FRAME_NO - 1) {
            return next = new LastFrame(no + 1);
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

    public int calculateAdditionalScore(Score beforeScore) {
        if (!Ready.isReady(state)) {
            beforeScore = state.updateScore(beforeScore);
        }
        if (beforeScore.canCalculateScore()) {
            return beforeScore.getScore();
        }
        if (next != null) {
            return next.calculateAdditionalScore(beforeScore);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "no : " + no + ", next : " + next.toString() + ", state : " + state.printState();
    }
}