package bowling.domain;

import bowling.enums.FrameStatus;

import java.util.Objects;

public class Player {
    private String name;
    private Frames frames;
    private int round;

    public Player(String name) {
        inputValidationCheck(name);

        this.name = name;
        this.frames = new Frames();
        this.round = 0;
    }

    private void inputValidationCheck(String name) {
        if(name == null || name.length() != 3)
            throw new IllegalArgumentException("name must be three english letter");
    }

    public FrameStatus getState() {
        return frames.getState(round);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
