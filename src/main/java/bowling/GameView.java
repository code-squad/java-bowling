package bowling;

import java.util.stream.IntStream;

import static bowling.BowlingUtils.BEGIN_FORMAT;
import static bowling.BowlingUtils.EMPTY_FRAME;
import static bowling.BowlingUtils.ING_FORMAT;
import static bowling.BowlingUtils.MAX_SCORE;
import static bowling.BowlingUtils.MIN_SCORE;

public class GameView {
    private static String resultView;

    public GameView(BowlingUser bowlingUser) {
        resultView = initFrames(initNameView(bowlingUser));
    }

    public static GameView generate(BowlingUser bowlingUser) {
        return new GameView(bowlingUser);
    }

    private String initNameView(BowlingUser bowlingUser) {
        return String.format(BEGIN_FORMAT, bowlingUser.getName());
    }

    private String initFrames(String nameView) {
        StringBuilder builder = new StringBuilder(nameView);
        IntStream.rangeClosed(MIN_SCORE, MAX_SCORE).forEach(i -> builder.append(String.format(ING_FORMAT, EMPTY_FRAME)));
        return builder.toString();
    }

    public String get() {
        return resultView;
    }
}
