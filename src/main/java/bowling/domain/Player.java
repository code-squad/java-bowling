package bowling.domain;

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
}
