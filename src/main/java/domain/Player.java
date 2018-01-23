package domain;

import org.apache.commons.lang3.StringUtils;

public class Player {
    private final String name;

    public Player(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "| " + "NAME" + " |" + "\n" + "| " + name + " |";
    }
}
