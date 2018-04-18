package domain.pitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pitches {
    private static final int DEFAULT_START_PIN_COUNT = 10;
    private List<Pitch> pitches;

    public Pitches(int firstPitch) {
        pitches = new ArrayList<>(Arrays.asList(new Pitch(DEFAULT_START_PIN_COUNT, firstPitch)));
    }

    public Pitch get(int pitchNumber) {
        return pitches.get(pitchNumber - 1);
    }

    public boolean has(int pitchNumber) {
        if(pitchNumber < pitches.size()) {
            return true;
        }
        return false;
    }

    public Pitch getLast() {
        return pitches.get(pitches.size() - 1);
    }

    public Pitches add(int pinCount) {
        int remainPinCount = getLast().getRemainPinCount();
        pitches.add(new Pitch(remainPinCount == 0 ? DEFAULT_START_PIN_COUNT : remainPinCount, pinCount));
        return this;
    }

    public Stream<Pitch> stream() {
        return pitches.stream();
    }
}
