package bowling.domain.frame;

import bowling.domain.status.Status;

public class NormalFrame implements Frame {
    private Status status;

    public int getScore() {
        return status.getScore();
    }

    //너무 복잡해 진다.. 다른 방법은?
    public int calculateAdditionalScore(Frame prevFrame) {
        if (prevFrame.isStrike() && this.isStrike()) { //연속 스트라이크일 경우 다음다음 점수의 첫번째 점수만 가져와야 하는데
            // nextFrame.getScore()를 하면 해당 상태의 점수(첫번째, 두번째)의 종합이 리턴되기 때문에
            // 따로 나눠야 할 필요가 있다?
            return getScore() +
        }
        if (prevFrame.isStrike() && this.isAllPlayed()) {

        }
        if (prevFrame.isSpare() && this.isPlayedOnce()) {

        }
        throw new CannotCalculateAdditionalScoreException();
    }
}