package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    private Player player;
    private List<Frame> frames;

    public BowlingGame(Player player) {
        this.player = player;
        initFrames();
    }

    public void progressGame(Integer numberOfFallingPin) {
        if (numberOfFallingPin > 10){
            throw new IllegalArgumentException("볼린 핀의 개수는 최대 10개 입니다.");
        }

        getCurrentFrame().obtainScore(numberOfFallingPin);

        if (isItOverAndHasNextFrame()){
            if (getCurrentFrameNumber() >= 9) {
                addFinalFrames();
            }
            if (getCurrentFrameNumber() < 9) {
                addNormalFrame();
            }
        }
    }

    public List<BowlingScore> getResult() {
        return frames.stream().map(frame -> frame.getScore()).collect(Collectors.toList());
    }

    public String getPlayerName() {
        return player.getName();
    }

    public boolean isItOverAndHasNextFrame() {
        return getCurrentFrame().isItOverAndHasNextFrame(getCurrentFrame());
    }

    public Integer getCurrentFrameNumber() {
        return frames.size();
    }

    public boolean isLast() {
        return getCurrentFrame().isDone(getCurrentFrame());
    }

    private void initFrames() {
        this.frames = new ArrayList();
        addNormalFrame();
    }

    private void addNormalFrame() {
        this.frames.add(new NormalFrame());
    }

    private void addFinalFrames() {
        this.frames.add(new FinalFrame());
    }

    private Frame getCurrentFrame() {
        return frames.get(frames.size() - 1);
    }
}
