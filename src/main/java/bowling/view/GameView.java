package bowling.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import bowling.domain.BowlingUser;
import bowling.domain.frame.Frame;

import static bowling.domain.score.ScoreType.STRIKE;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.BEGIN_FORMAT;
import static bowling.utils.StringUtils.DEFAULT_ING_FORMAT;
import static bowling.utils.StringUtils.EMPTY_BLOCK_FRAME;
import static bowling.utils.StringUtils.EMPTY_FRAME;
import static bowling.utils.StringUtils.emptyBlockFormat;
import static bowling.utils.StringUtils.getIngFormat;
import static bowling.utils.StringUtils.getIngOnlyFormat;

public class GameView {
    private List<Frame> frames = new ArrayList<>();
    private static String resultView;

    public GameView(BowlingUser bowlingUser) {
        resultView = initNameView(bowlingUser);
    }

    public static GameView generate(BowlingUser bowlingUser) {
        return new GameView(bowlingUser);
    }

    public String firstReflectScore(Frame frame) {
        frames.add(frame);
        resultView += getIngOnlyFormat(frame.result());
        if(isStrikeAndFormat(frame)) return resultView;
        return resultView + EMPTY_BLOCK_FRAME;
    }

    public String nextReflectScore(Frame frame) {
        updateResultView(frame, 1);
        //if(isGutterAndFormat(frame)) return resultView;
        resultView = getIngFormat(resultView);
        return resultView;
    }

    public String nextFinalScore(Frame frame) {
        updateResultView(frame, 5);
        return resultView;
    }

    private void updateResultView(Frame frame, int deleteLength) {
        resultView = clearBeforeData(resultView.length() - deleteLength) + frame.result();
    }

    private boolean isStrikeAndFormat(Frame frame) {
        return isEmptyBlockTarget(STRIKE.match(frame.getElement()));
    }

    private boolean isEmptyBlockTarget(boolean isTarget) {
        if(isTarget) {
            resultView = emptyBlockFormat(resultView);
            return true;
        }
        return false;
    }

    public String initEmptyFrames(String nameView, int ingLength) {
        StringBuilder builder = new StringBuilder(nameView);
        IntStream.range(MIN_SCORE, MAX_SCORE-ingLength).forEach(i -> builder.append(String.format(DEFAULT_ING_FORMAT, EMPTY_FRAME)));
        return builder.toString();
    }

    public String firstFrame() {
        return initEmptyFrames(resultView, MIN_SCORE);
    }

    private String clearBeforeData(int endIndex) {
        return resultView.substring(0, endIndex);
    }

    private String initNameView(BowlingUser bowlingUser) {
        return String.format(BEGIN_FORMAT, bowlingUser.getName());
    }

}
