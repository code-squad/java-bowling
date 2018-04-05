package domain;

public class PlayerName {
    public static final int LENGTH = 5;
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
}
