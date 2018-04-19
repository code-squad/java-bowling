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

//    public int calculateScore(Frames frames) { //TODO: exception for frame number = 8,
//        if (score.noMoreBowlNeeded()) {
//            return status.updateScore(score);
//        }
//        if (score.oneMoreBowlNeeded()) {
//            return status.updateScore(score) + frames.getNext(frameNumber).calculateAdditionalScore(score);
//        }
//        //if count == 2
//        int first = frames.getNext(frameNumber).calculateAdditionalScore(score);
//        int second = frames.getNextNext(frameNumber).calculateAdditionalScore(score);
//        return status.updateScore(score) + first + second;
//    }

    public int calculateScore2(Frames frames) { //TODO: Exception for frame number = 8
        if (score.twoMoreBowlsNeeded()) {
            frames.getNext(frameNumber).calculateAdditionalScore(score);
            frames.getNextNext(frameNumber).calculateAdditionalScore(score);
        }
        if (score.oneMoreBowlNeeded()) {
            frames.getNext(frameNumber).calculateAdditionalScore(score);
        }
        if (score.noMoreBowlNeeded()) {
            status.updateScore(score);
        }
        return score.getScore();
    }

    public int calculateAdditionalScore(Score prevScore) {
        if (!status.isComplete()) { //프레임이 끝나야 되는게 아니라 count가 0이면!!
            throw new FrameNotCompleteException();
        }
        status.updateScore(score);
    }
}