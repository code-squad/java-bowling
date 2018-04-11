package saru;

import java.util.ArrayList;
import java.util.List;

public class 투구현황 {
    public static final int NORMAL_COUNT = 2;
    public static final int LAST_COUNT = 3;
    private int 맥스투구횟수;

    private List<DownPin> downPins = new ArrayList<>();

    private 투구현황(int 맥스투구횟수) {
        this.맥스투구횟수 = 맥스투구횟수;
    }

    public static 투구현황 of(int ballCount) {
        if (ballCount != NORMAL_COUNT && ballCount != LAST_COUNT) {
            throw new IllegalArgumentException("볼카운트가 잘못됨");
        }

        return new 투구현황(ballCount);
    }

    public int 현재투구횟수() {
        return downPins.size();
    }

    public void 투구(DownPin pinCount) {
        downPins.add(pinCount);
    }

    DownPin 투구결과() {
        return downPins.get(downPins.size() - 1);
    }
}
