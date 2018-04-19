package domain;

public class FrameNo {
    private int no;
    public static final int MIN = 1;
    public static final int MAX = 10;


    public FrameNo(int no) {
        if (MIN > no || MAX < no) {
            throw new IllegalArgumentException("볼링은 1 ~ 10프레임만 존재합니다.");
        }
        this.no = no;
    }

    public int getNo() {
        return no;
    }

}
