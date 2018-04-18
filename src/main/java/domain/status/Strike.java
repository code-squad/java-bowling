package domain.status;

import domain.Score;

import java.util.List;

public class Strike extends FrameStatus{

    private Strike() {
        super(0);
     }

    public static Strike of() {
        System.out.println("스트라이크");
        return new Strike();
    }

    public void takeAdditionalFromPresent(FrameStatus frameStatus, List<Score> scores) {
        if (frameStatus.isStrike()) {
            addScore(frameStatus, scores.get(0));
            return;
        }
        addScore(Score.of(scores.get(0).sumPrint(scores.get(1))));
    }
}
