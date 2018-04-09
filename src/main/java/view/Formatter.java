package view;


public class Formatter {
    private static final int MAX_FRAME_LENGTH = 5;

    public static String formatFrame(String frameElement) {
        StringBuilder builder = new StringBuilder();
        builder.append("  ").append(frameElement); //왼쪽 기본 공백
        int diff = MAX_FRAME_LENGTH - frameElement.length();
        for (int i = 0; i < diff; i++) {
            builder.append(" "); //오른쪽 공백
        }
        return builder.toString();
    }
}
