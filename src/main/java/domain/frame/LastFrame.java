package domain.frame;

import domain.frame.pin.Pin;
import domain.frame.result.Board;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;
import domain.frame.status.FrameStatus;
import domain.frame.status.Ready;

import java.util.LinkedList;

import static domain.frame.result.ScoreMessage.getMessage;
import static java.util.stream.Collectors.joining;

public class LastFrame implements Frame {
    private LinkedList<FrameStatus> states = new LinkedList<>();

    public LastFrame() {
        states.add(new Ready());
    }

    @Override
    public Frame roll(int num) throws IllegalArgumentException {
        FrameStatus resultStatus = getRecentlyStatus().roll(new Pin(num));
        replaceRecentlyStatus(resultStatus);
        if (getRecentlyScore().hasBonusCount()) {
            addReadyStatus(num);
        }
        return this;
    }

    private void replaceRecentlyStatus(FrameStatus status) {
        states.set(states.indexOf(getRecentlyStatus()), status);
    }

    private void addReadyStatus(int num) { // pin num과 status로 충분히 평가 가능한거 같은데 Pin.isMax가 있으니
        if (states.size() > 2 || (states.size() == 2 && !Pin.isMax(num))) {
            return;
        }
        states.add(new Ready());
    }

    private FrameStatus getRecentlyStatus() {
        return states.getLast();
    }

    private Score getRecentlyScore() {
        return states.getLast().getScore();
    }

    @Override
    public boolean isLast() {
        return true;
    }

    @Override
    public boolean isFinish() {
        return getRecentlyStatus().isFinish();
    }

    @Override
    public int getFrameNum() {
        return 10;
    }

    @Override
    public Board getBoard() {
        throw new UnsupportedOperationException(); // 다음 프레임이 없으니깐
    }

    @Override
    public void addFrameResult(Board board) {
        FrameResult result = getResult();
        board.addResult(result);
    }

    @Override
    public FrameResult getResult() {
        if (!isFinish()) {
            return new FrameResult(getResultMessage(), Frame.CANNOT_CALC_SCORE_STATE);
        }
        return new FrameResult(getResultMessage(), getScore());
    }

    private String getResultMessage() {
        return states.stream().filter(status -> !status.getResultMessage().equals("")).map(FrameStatus::getResultMessage).collect(joining(getMessage(ScoreMessage.MODIFIER)));
    }

    private int getScore() {
        return states.stream().mapToInt(frameStatus -> frameStatus.getScore().get()).sum();
    }

    @Override
    public Score addRemainingPin(Score beforeFrameScore) {
        Score score = beforeFrameScore;
        for (FrameStatus status : states) {
            score = status.addBonusScore(beforeFrameScore);
        }
        return score;
    }
}
