package bowling.domain;

import bowling.domain.frame.Frame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.*;

public class Game {
    private List<Frame> frames = new ArrayList<>();
    private BowlingUser bowlingUser;

    public Game(BowlingUser bowlingUser) {
        this.bowlingUser = bowlingUser;
    }

    public static Game generate(BowlingUser bowlingUser) {
        return new Game(bowlingUser);
    }

    public String reflectView(Frame frame) {
        if(frames.contains(frame)) { frames.remove(frame); }
        frames.add(frame);

        return createView(frames.stream().map(f -> emptyBlockFormat(f.result())).collect(Collectors.joining()));
    }

    public String reflectFinalView(Frame frame) {
        if(frames.contains(frame)) { frames.remove(frame); }
        frames.add(frame);

        return initName() + frames.stream().map(f -> emptyBlockFormat(f.result())).collect(Collectors.joining());
    }

    public String createView(String scoreView) {
        return initName() + scoreView + rightEmpty(frames.size());
    }

    private String initName() {
        return String.format(BEGIN_FORMAT, bowlingUser.getName());
    }

    public String rightEmpty(int ingLength) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(MIN_SCORE, MAX_SCORE-ingLength).forEach(i -> builder.append(String.format(DEFAULT_ING_FORMAT, EMPTY_FRAME)));
        return builder.toString();
    }

}
