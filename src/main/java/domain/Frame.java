package domain;

import state.State;

abstract public class Frame {
    private static final int MAX_FRAME_NO = 10;
//    private Score score;
    private Score beforeScore;
    private final int no;

    public Frame(int no, Score beforeScore) {
        isValidNo(no);
        this.no = no;
        this.beforeScore = beforeScore;
    }

    abstract public void throwing(int throwing);
    abstract public State updateState(int throwing);
    abstract public boolean isEnd();
    abstract public String printState();
    abstract public String printScore();

    public boolean isValidNo(int no) {
        if ( no < 0 || no > 10 ) {
            throw new RuntimeException("프레임의 번호는 0부터 10사이 입니다. 생성 시도한 프레임 번호는 " + no);
        }
        return true;
    }

    public Frame next() {
        if (no == MAX_FRAME_NO - 1) {
            return new LastFrame(no + 1);
        }
        return new NormalFrame(no + 1);
    }

    public abstract Score createScore();
}
