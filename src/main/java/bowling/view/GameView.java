package bowling.view;

import bowling.domain.BowlingUser;
import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.*;

public class GameView {
    private List<Frame> frames = new ArrayList<>();
    @Deprecated
    private static String resultView;

    public GameView(BowlingUser bowlingUser) {
        resultView = initNameView(bowlingUser);
    }

    public static GameView generate(BowlingUser bowlingUser) {
        return new GameView(bowlingUser);
    }

    public String reflectView(NormalFrame frame) {
        if(frames.contains(frame)) { frames.remove(frame); }
        frames.add(frame);

        String result = String.format(BEGIN_FORMAT, BowlingUser.getName());
        result += frames.stream().map(f -> emptyBlockFormat(f.result())).collect(Collectors.joining());
        return result;
    }

    public String nextFinalScore(Frame frame) {
        updateResultView(frame, 5);
        return resultView;
    }

    private void updateResultView(Frame frame, int deleteLength) {
        resultView = clearBeforeData(resultView.length() - deleteLength) + frame.result();
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
