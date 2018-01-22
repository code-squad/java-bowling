package bowling.domain;

import java.util.Objects;

public class Player {
    private String name;
    private Frames frames;

    public Player(String name) {
        inputValidationCheck(name);
        this.name = name;
        this.frames = new Frames();
    }

    private void inputValidationCheck(String name) {
        if(name == null || name.length() != 3)
            throw new IllegalArgumentException("name must be three english letter");
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
