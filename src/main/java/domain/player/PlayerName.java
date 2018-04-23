package domain.player;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class PlayerName {
    public static final int LENGTH = 3;
    private String name;

    public PlayerName(String name) {
        if (!isValidNameLength(name)) {
            throw new IllegalArgumentException("이름은 " + LENGTH + "자로 해야함");
        }

        if (!isValidEnglishName(name)) {
            throw new IllegalArgumentException("영어만 입력 해야함");
        }
        this.name = name;
    }

    public static boolean isValidNameLength(String name) {
        return name.length() == LENGTH;
    }

    public static boolean isValidEnglishName(String name) {
        char[] convertName = name.toCharArray();
        for (char ch : convertName) {
            if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicateName(List<PlayerName> playersName) {
        return new HashSet<>(playersName).size() != playersName.size();
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String checkName) {
        return this.name.equals(checkName);
    }

    @Override
    public boolean equals(Object otherPlayerName) {
        if (this == otherPlayerName) return true;
        if (otherPlayerName == null || getClass() != otherPlayerName.getClass()) return false;
        PlayerName that = (PlayerName) otherPlayerName;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
