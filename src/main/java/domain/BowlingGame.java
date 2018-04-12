package domain;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private static final int MAX_NO = 10;
    private Player player;
    private List<Frame> frames;

    public BowlingGame(String name) {
        this.player = createPlayer(name);
    }

    public static Player createPlayer(String name) {
        return new Player(name);
    }

    public List<Frame> createFrame() {
        frames = new ArrayList<>();
        for (int frameNo = 1; frameNo <= MAX_NO; frameNo++) {
            if (frameNo == MAX_NO) {
                frames.add(new LastFrame(frameNo));
                break;
            }
            frames.add(new NormalFrame(frameNo));
        }
        if (frames.size() != 10) {
            throw new RuntimeException("1~10프레임까지 존재합니다.");
        }
        return frames;
    }
}
