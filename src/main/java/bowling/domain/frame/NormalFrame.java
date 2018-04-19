package bowling.domain.frame;

import bowling.domain.score.Score;
import bowling.domain.status.Status;

public class NormalFrame implements Frame {
    private final int frameNumber;
    private Status status;
    private Score score;

    public NormalFrame(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public void bowl(int pins) {
        status = status.bowl(pins);
        if (status.isComplete()) {
            score = status.createScore();
        }
    }

    public int calculateScore(Frames frames) { //TODO: exception for frame number = 8,
        if (score.countUntilCalcIsTwo) {
            frames.getNext(frameNumber).calculateAdditionalScore(score);
            frames.getNextNext(frameNumber).calculateAdditionalScore(score);
        }
        if (score.countUntilCalcIsZero()) {
            //score.bowl(status.getBothBowl());
            return status.updateScore(score);
        }
        if (score.countUntilCalcIsOne()) {
            return status.updateScore(score) + frames.getNext(frameNumber).calculateAdditionalScore(score);
        }
        //if count == 2
        int first = frames.getNext(frameNumber).calculateAdditionalScore(score);
        int second = frames.getNextNext(frameNumber).calculateAdditionalScore(score);
        return status.updateScore(score) + first + second;
    }

    public int calculateAdditionalScore(Score prevScore) {
        if (!status.isComplete()) { //프레임이 끝나야 되는게 아니라 count가 0이면!!
            throw new FrameNotCompleteException();
        }
        if (prevScore.countUntilCalcIsOne()) {
            //prevScore.bowl(status.getFirstBowl());
            status.updateScore(prevScore); //만약 count = 1이면 하나만..
        }
        //if (prevScore.countUntilCalcIsZero()) {
        //prevScore.bowl(status.getBothBowl());
        status.updateScore(prevScore);
        //}
    }
}