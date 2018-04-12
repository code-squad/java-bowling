package bowling.domain;

public class Validator {

    public static String validateName(String name) {
        if (name.length() != 3) {
            throw new IllegalArgumentException("세 자만 입력해 주세요.");
        }
        return name;
    }

    public static boolean isValidScore(int pinsKnocked, int pinsStanding) {
        if (pinsKnocked > 10 || pinsKnocked < 0) {
            return false;
        }
        if (pinsKnocked > pinsStanding) {
            return false;
        }
        return true;
    }
}