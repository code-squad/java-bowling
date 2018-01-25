package bowling.domain;

public class Name {

    private String name;

    public Name(String name) {
        this.name = name;
        if (!isName(name)) throw new IllegalArgumentException();
    }

    private boolean isName(String name) {
        return name.matches("[a-zA-Z]{1,3}");
    }

    @Override
    public String toString() {
        return String.format("| %4s |",name);
    }
}