package game;

import java.util.List;

public class BowlFrame {
    private Score score;
    private Status status;

    public BowlFrame() {
        score = new Score(0);
        status = new Status();
    }

    public List<Integer> shot(int firstShot) {
        System.out.println(firstShot + "개를 맞췄습니다.");
        score.getNumbers().add(firstShot);
        return score.getNumbers();
    }

    public void next(int i) {

    }
}
