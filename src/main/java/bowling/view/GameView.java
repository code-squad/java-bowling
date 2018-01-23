package bowling.view;

import java.util.stream.IntStream;

import bowling.domain.BowlingUser;
import bowling.domain.frame.NormalFrame;

import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.StringUtils.BEGIN_FORMAT;
import static bowling.utils.StringUtils.EMPTY_BLOCK_FRAME;
import static bowling.utils.StringUtils.EMPTY_FRAME;
import static bowling.utils.StringUtils.DEFAULT_ING_FORMAT;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.getIngOnlyFormat;

public class GameView {
    private static String resultView;

    public GameView(BowlingUser bowlingUser) {
        resultView = initNameView(bowlingUser);
    }

    public static GameView generate(BowlingUser bowlingUser) {
        return new GameView(bowlingUser);
    }

    public String firstReflectScore(NormalFrame frame) {
        resultView += getIngOnlyFormat(frame.result());
        if(STRIKE.isStrike(frame.getFrameElement())) { return resultView; }
        return resultView + EMPTY_BLOCK_FRAME;
    }

    public String nextReflectScore(NormalFrame frame) {
        resultView = clearBeforeData() + frame.result();
        return resultView;
    }

    private String clearBeforeData() {
        return resultView.substring(0, resultView.length()-1);
    }

    private String initNameView(BowlingUser bowlingUser) {
        return String.format(BEGIN_FORMAT, bowlingUser.getName());
    }

    public String initEmptyFrames(String nameView, int ingLength) {
        StringBuilder builder = new StringBuilder(nameView);
        IntStream.range(MIN_SCORE, MAX_SCORE-ingLength).forEach(i -> builder.append(String.format(DEFAULT_ING_FORMAT, EMPTY_FRAME)));
        return builder.toString();
    }

    public String firstFrame() {
        return initEmptyFrames(resultView, MIN_SCORE);
    }

}
