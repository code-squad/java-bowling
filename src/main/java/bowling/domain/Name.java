package bowling.domain;

import bowling.io.InputView;

public class Name {

    private String name;

    public Name(String name) {
        this.name = name;
        if (!InputView.isName(name)) throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return String.format("| %4s |",name);
    }
}