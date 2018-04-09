package utils;

public class InputUtils {

    public static int convertToNumber(String scoreMessage) throws IllegalArgumentException {
        try {
            return Integer.parseInt(scoreMessage);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }
}
