package domain;

public class Player {
    private PlayerName name;

    public Player(String name) throws IllegalArgumentException {
        this.name = new PlayerName(name);
    }

}
