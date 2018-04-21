package domain;

import state.State;

abstract public class Frame {
    private static final int MAX_FRAME_NO = 10;
//    private Score score;
//    private Score beforeScore;
    public Frame(int no) {
        isValidNo(no);
    }

    abstract public void throwing(int throwing);
    abstract public State updateState(int throwing);
    abstract public boolean isEnd();
    abstract public String printState();
    abstract public String printScore();
    abstract public Score createScore();
    abstract public int getScore();
    abstract public Frame next();

    public boolean isValidNo(int no) {
        if ( no < 0 || no > 10 ) {
            throw new RuntimeException("프레임의 번호는 0부터 10사이 입니다. 생성 시도한 프레임 번호는 " + no);
        }
        return true;
    }



    abstract public int calculateAdditionalScore(Score beforeScore);
}
