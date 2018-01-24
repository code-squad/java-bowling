package model;

import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    private Player player;
    private List<Frame> frames;

    public BowlingGame(Player player) {
        this.player = player;
        frames = CreateFrame.initFrames(frames);
    }

    public Boolean progressGame(Integer numberOfFallingPin) {
        if (isIllegalParam(numberOfFallingPin)) {
            throw new IllegalArgumentException("볼린 핀의 개수는 0개 에서 10개 입니다.");
        }

        getCurrentFrame().obtainScore(numberOfFallingPin);
        if (isItOverAndHasNextFrame()) {
            CreateFrame.create(frames);
        }
        return false;
    }

    private boolean isIllegalParam(Integer numberOfFallingPin) {
        return numberOfFallingPin < 0 || numberOfFallingPin > 10;
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
        return getCurrentFrame().isDone();
    }

    private Frame getCurrentFrame() {
        return frames.get(frames.size() - 1);
    }
}
