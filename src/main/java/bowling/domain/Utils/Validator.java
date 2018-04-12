package bowling.domain.Utils;

public class Validator {

    public static String validateName(String name) throws IllegalArgumentException {
        if (name.length() != 3) {
            throw new IllegalArgumentException("세 자만 입력해 주세요.");
        }
        return name;
    }
}