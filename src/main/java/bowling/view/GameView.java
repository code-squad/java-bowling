package bowling.view;

import java.util.stream.IntStream;

import bowling.domain.BowlingUser;
import bowling.domain.score.Score;

import static bowling.utils.BowlingUtils.BEGIN_FORMAT;
import static bowling.utils.BowlingUtils.EMPTY_FRAME;
import static bowling.utils.BowlingUtils.ING_FORMAT;
import static bowling.utils.BowlingUtils.MAX_SCORE;
import static bowling.utils.BowlingUtils.MIN_SCORE;

public class GameView {
    private static String resultView;

    public GameView(BowlingUser bowlingUser) {
        resultView = initEmptyFrames(initNameView(bowlingUser), MAX_SCORE);
    }

    public static GameView generate(BowlingUser bowlingUser) {
        return new GameView(bowlingUser);
    }

    public GameView reflectScore(Score score) {

        return this;
    }

    private String initNameView(BowlingUser bowlingUser) {
        return String.format(BEGIN_FORMAT, bowlingUser.getName());
    }

    private String initEmptyFrames(String nameView, int emptyLength) {
        StringBuilder builder = new StringBuilder(nameView);
        IntStream.range(MIN_SCORE, emptyLength).forEach(i -> builder.append(String.format(ING_FORMAT, EMPTY_FRAME)));
        return builder.toString();
    }

    public String get() {
        return resultView;
    }
}
