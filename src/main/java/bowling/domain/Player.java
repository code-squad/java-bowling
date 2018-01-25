package bowling.domain;

public class Player {
    private String name;

    private Player(String name) {
        if(name == null || name.length() != 3 || !name.matches("^[a-zA-Z]{3}")) {
            throw new IllegalArgumentException("플레이어 이름은 영문 세글자 이어야 합니다.");
        }
        this.name = name.toUpperCase();
    }

    public static Player of (String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}
