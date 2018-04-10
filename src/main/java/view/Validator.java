package view;

public class Validator {

    public static String validateName(String name) throws IllegalArgumentException {
        if (name.length() != 3) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    public static int validateScore(String throwScore) throws IllegalArgumentException {
        int score;
        try {
            score = Integer.parseInt(throwScore);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
        if (score > 10 || score <= 0) {
            throw new IllegalArgumentException("1 에서 10 사이의 숫자만 입력해 주세요");
        }
        return score;
    }
}
