package domain.status;

import domain.Score;

import java.util.List;

public class Spare extends FrameStatus {

    private Spare() {
        super(0);
    }

    public static Spare of() {
        System.out.println("스페어");
        return new Spare();
    }

    public void takeAdditionalFromPresent(FrameStatus frameStatus, List<Score> scores) {
        if ((frameStatus.isOpen() || frameStatus.isSpare()) && frameStatus.isEnd()) return;
        addScore(scores.get(0));
    }
}
