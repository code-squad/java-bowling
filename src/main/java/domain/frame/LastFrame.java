package domain.frame;

import domain.frame.pin.Pin;
import domain.frame.result.Board;
import domain.frame.result.CannotCalcException;
import domain.frame.result.FrameResult;
import domain.frame.result.Score;
import domain.frame.status.FrameStatus;
import domain.frame.status.Ready;

import java.util.ArrayList;

public class LastFrame implements Frame {
    private final int frameNum;
    // 사실상 BonusStatus 중복이었음
    private ArrayList<FrameStatus> states = new ArrayList<>();

    public LastFrame(int frameNum) {
        this.frameNum = frameNum;
        states.add(new Ready());
    }

    @Override
    public Frame roll(int num) throws IllegalArgumentException {
        FrameStatus status = getRecentlyStatus();
        status = status.roll(new Pin(num));
        if (status.isFinish()) {
            states.add(status);
            return this;
        }
        states.add(0, status);
        return this;
    }

    public FrameStatus getRecentlyStatus() {
        return states.get(states.size() - 1);
    }

    @Override
    public boolean isLast() {
        return true;
    }

    @Override
    public boolean isFinish() {
        FrameStatus recentlyStatus = getRecentlyStatus();
        return recentlyStatus.isFinish();
    }

    @Override
    public boolean isDiff(Frame frame) {
        return this == frame;
    }

    @Override
    public int getFrameNum() {
        return frameNum;
    }

    /************ 여기부터 다시 구현 **************/

    @Override
    public Board getBoard() {
        throw new UnsupportedOperationException(); // 다음 넥스트 프레임이 없음
    }

    @Override
    public void addFrameResult(Board board) {
        FrameResult result = getResult();
        board.addResult(result);
    }

    @Override
    public FrameResult getResult() {
        return null;
    }

    @Override
    public int getRemainingPin() {
        Score score = getRecentlyStatus().getScore();
        return score.get();
    }

    @Override
    public Score addRemainingPin(Score beforeFrameScore) {
        return null;
    }

    @Override
    public Score AddAdditionalRemainingPin(Score unFinishedScore) {
        throw new CannotCalcException();
    }
}
