package model;

import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    private Player player;
    private List<Frame> frames;
    private BowlingResult bowlingResult;

    public BowlingGame(Player player) {
        this.player = player;
        frames = CreateFrame.initFrames(frames);
        bowlingResult = new BowlingResult();
    }

    public void progressGame(Integer numberOfFallingPin) {
        if (isIllegalParam(numberOfFallingPin)) {
            throw new IllegalArgumentException("볼린 핀의 개수는 0개 에서 10개 입니다.");
        }

        Score thisScore = getCurrentFrame().obtainScore(numberOfFallingPin);
        bowlingResult.calculateNextTrial(thisScore);

        if (!isItOverAndHasNextFrame()) {
            calculateLastEveryThings();
        }
        if (isItOverAndHasNextFrame()) {
            CalculateCurrentFrame();
        }
    }

    private void CalculateCurrentFrame() {
        bowlingResult.calculateUntilNow(getCurrentFrame());
        if (bowlingResult.stillCanCalculate()) {
            bowlingResult.calculateUntilNow(getCurrentFrame());
        }
        CreateFrame.create(frames);
    }

    private void calculateLastEveryThings() {
        if (getCurrentFrameNumber() >= 10 && !bowlingResult.hasMoreTrial() && getCurrentFrame().hasAllScore()){
            bowlingResult.calculateLast(getCurrentFrame().calculateLast());
        }
        if (getCurrentFrameNumber() >= 10 && bowlingResult.hasNotEmptyQueue()){
            bowlingResult.calculateUntilNow(getCurrentFrame());
        }
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
        return getCurrentFrame().isItOverAndHasNextFrame();
    }

    public Integer getCurrentFrameNumber() {
        return frames.size();
    }

    public List<String> getBowlingResultOnlyString(){
        return bowlingResult.getResult(getResult());
    }

    public List<String> getTotalScore(){
        return bowlingResult.getTotalScore();
    }

    public boolean isLast() {
        return getCurrentFrame().isDone();
    }

    private Frame getCurrentFrame() {
        return frames.get(frames.size() - 1);
    }

    public boolean hasMoreTrial() {
        return getCurrentFrame() instanceof NormalFrame || bowlingResult.hasMoreTrial();
    }

    public boolean hasMoreFrame() {
        if (getCurrentFrameNumber() > 10 && getCurrentFrame().hasAnyScore() && !bowlingResult.hasMoreTrial()){
            return false;
        }

        if (getCurrentFrameNumber() == 10 && !getCurrentFrame().hasAllScore()) {
            return true;
        }

        if (bowlingResult.stillCanCalculate()){
            return true;
        }
        return false;
    }

    public BowlingResult getBowlingResult() {
        return bowlingResult;
    }
}
