package domain.pitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pitches {
    private List<Pitch> pitches;

    public Pitches(int firstPitch) {
        pitches = new ArrayList<>(Arrays.asList(new Pitch(firstPitch)));
    }

    public Pitch get(int pitchNumber) {
        return pitches.get(pitchNumber - 1);
    }
    
    public Pitch getLast() {
        return pitches.get(pitches.size() - 1);
    }

    public List<Pitch> getList() {
        return pitches;
    }

    public boolean has(int pitchNumber) {
        return pitchNumber <= pitches.size();
    }

    public Pitches add(int pinCount) {
        int remainPinCount = getLast().getRemainPinCount();
        pitches.add(remainPinCount == 0 ? new Pitch(pinCount) : new Pitch(remainPinCount, pinCount));
        return this;
    }

    public Stream<Pitch> stream() {
        return pitches.stream();
    }

    public int sum() {
        return pitches.stream()
                .mapToInt(Pitch::getPinCount)
                .sum();
    }
}
