package domain;

import state.State;

abstract public class Frame {
    private static final int MAX_FRAME_NO = 10;

    public Frame(int no) {
        isValidNo(no);
    }

    abstract public State bowl(Pins falledPins);
    abstract public boolean isEnd();
    abstract public String printState();
    abstract public Score createScore(int beforeScore);
    abstract public int getScore(int beforeScore);
    abstract public Frame next();
    abstract public boolean isLastFrame();
    abstract public int calculateAdditionalScore(Score beforeScore);

    public boolean isValidNo(int no) {
        if ( no < 0 || no > 10 ) {
            throw new RuntimeException("프레임의 번호는 0부터 10사이 입니다. 생성 시도한 프레임 번호는 " + no);
        }
        return true;
    }
}
