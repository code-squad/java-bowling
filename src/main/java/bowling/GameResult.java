package bowling;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author sangsik.kim
 */
public class GameResult {
    private String playerName;
    private Map<Integer, Score> scores = new HashMap<>();

    public GameResult(String playerName) {
        this.playerName = playerName;
    }

    public GameResult addScore(Score score) {
        this.scores.put(score.getFrameNumber(), score);
        return this;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getScore(int frameNumber) {
        return Optional.ofNullable(scores.get(frameNumber))
                .map(Score::toText)
                .orElse(StringUtils.EMPTY);
    }
}
