package bowling.domain.Utils;

public class Validator {
    private static final int MAX_NAME_LENGTH = 3;

    public static String validateName(String name) throws IllegalArgumentException {
        if (name.length() != MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("세 자만 입력해 주세요.");
        }
        return name;
    }
}