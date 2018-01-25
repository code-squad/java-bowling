package bowling.util;

import bowling.domain.Pin;

import java.util.Optional;

public class ScoreCalculator {
    public static Integer calculateFrame(Pin firstTry, Pin secondTry) {
        return Optional.ofNullable(firstTry)
                .map(pin -> pin.add(secondTry))
                .orElse(null);
    }

    public static Integer calculateStrike(Pin firstTry, Pin secondTry) {
        return Optional.ofNullable(calculateFrame(firstTry, secondTry))
                .map(score -> score + 10)
                .orElse(null);
    }

    public static Integer calculateSpare(Pin extraTry) {
        return Optional.ofNullable(extraTry)
                .map(Pin::calculateSpare)
                .orElse(null);
    }

    public static Integer calculateDoubleStrike(Integer extraScore) {
        return Optional.ofNullable(extraScore)
                .map(score -> score + 10)
                .orElse(null);
    }
}
