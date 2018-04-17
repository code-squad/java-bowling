package bowling.domain;

public class Strike extends FrameStatus {

    static final int COUNT_TWO = 2;

    private Strike(Ball first, Ball second) {
        super(first, second);
    }

    public static Strike of(Ball first, Ball second){
        return new Strike(first,second);
    }

    public boolean isLastBall(){
        return false;
    }

    public int pinOfFrame() {
        if (!isTwiceBall()){
            return 10;
    }
    return getFirst()+getSecond();
    }

    public int getCount(){
        return COUNT_TWO;
    }

    public String nomalPrint(){
        return "   X  |";
    }
}
