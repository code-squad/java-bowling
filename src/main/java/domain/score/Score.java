package domain.score;

import java.util.Optional;

public interface Score {

    boolean isFinish();

    void addResult(Pin pin);

    Optional<Integer> getFrameScore();

    boolean isStrike();

    Integer getFirstScore();

    Optional<Integer> getSumOfScore();
}
