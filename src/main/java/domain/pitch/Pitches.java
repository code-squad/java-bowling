package domain.pitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pitches {
    private List<Pitch> pitches;

    public Pitches(int firstPin) {
        pitches = new ArrayList<>(Arrays.asList(new Pitch(firstPin)));
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

    public Pitches add(int pin) {
        int leftPin = getLast().getLeftPin();
        pitches.add(leftPin == 0 ? new Pitch(pin) : new Pitch(leftPin, pin));
        return this;
    }

    public Stream<Pitch> stream() {
        return pitches.stream();
    }

    public int sum() {
        return pitches.stream()
                .mapToInt(Pitch::getPin)
                .sum();
    }
}
