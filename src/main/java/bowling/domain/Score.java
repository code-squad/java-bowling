package bowling.domain;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Score {

    private List<Shot> shots;

    public Score() {
        this.shots = Lists.newArrayList();
    }

    public Score sum(Shot shot) {
        shots.add(shot);

        return this;
    }

    public int totalNumberOfPin() {
        return shots.stream()
                .mapToInt(Shot::numberOfPin)
                .sum();
    }

    public int firstNumberOfPin() {
        if (shots.size() == 0) {
            return 0;
        }

        return shots.get(BowlingRule.FIRST_SHOT)
                .numberOfPin();
    }

    public int lastNumberOfPin() {
        if (shots.size() == 0 || shots.size() == 1) {
            return 0;
        }

        return shots.get(shots.size() - 1)
                .numberOfPin();
    }

    public FrameStatus status(boolean hasNext) {
        if (firstNumberOfPin() == Shot.MAX_NUMBER_OF_PIN) {
            return FrameStatus.STRIKE;
        }

        if ( ! hasNext && firstNumberOfPin() != Shot.MAX_NUMBER_OF_PIN &&
                totalNumberOfPin() == Shot.MAX_NUMBER_OF_PIN) {
            return FrameStatus.SPARE;
        }

        if ( ! hasNext && 0 < totalNumberOfPin() && totalNumberOfPin() < Shot.MAX_NUMBER_OF_PIN) {
            return FrameStatus.MISS;
        }

        if ( ! hasNext && totalNumberOfPin() == 0) {
            return FrameStatus.GUTTER;
        }

        return FrameStatus.PLAYING;
    }

    @Override
    public String toString() {
        return Optional.ofNullable(shots)
                .orElse(Lists.newArrayList())
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining("|"));
    }
}
