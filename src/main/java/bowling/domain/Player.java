package bowling.domain;

public class Player {
    private static final int NAME_LENGTH = 3;

    private String name;

    public Player(String name) {
        setName(name);
    }

    private void setName(String name) {
        if (NAME_LENGTH != name.length()) {
            throw new IllegalPlayerNameException(String.format("플레이어 이름은 %s자여야 합니다.", NAME_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasCorrectName() {
        return name != null && !name.equals("");
    }
}
