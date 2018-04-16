package bowling.domain.Util;

public class Parser {

    public static String parseName(String name) {
        if (name.length() != 3) {
            throw new IllegalArgumentException("3자의 이름만 가능합니다.");
        }
        return name;
    }

    public static int parseToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }
    }

    public static String formatFrame(String frame) {
        String leftPadded = String.format("%4s", frame);
        return String.format("%-5s", leftPadded);
    }
}