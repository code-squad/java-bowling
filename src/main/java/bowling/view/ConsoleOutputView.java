package bowling.view;

import bowling.domain.Frame;
import bowling.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleOutputView {
    private static final String FIRST_COLUMN = "NAME";
    private static final String DELIMITER = "|";

    public static void print(Player player, List<Frame> results) {
        List<List<String>> rows = new ArrayList<>();

        List<String> headers = new ArrayList<>();
        headers.add(FIRST_COLUMN);
        rows.add(headers);

        List<String> body = new ArrayList<>();
        body.add(player.getName());
        rows.add(body);

        results.forEach(frame -> {
            headers.add(String.format("%02d", frame.getFrameId()));
            body.add(frame.getScoreSymbol());
        });

        System.out.println(formatAsTable(rows));
    }

    public static void showErrorMessage(String message) {
        System.out.println(message);
    }

    private static String formatAsTable(List<List<String>> rows) {
        int[] maxLengths = new int[rows.get(0).size()];
        rows.forEach(row -> collectMaxLengths(maxLengths, row));

        String format = generateColumnFormat(maxLengths);
        return rows.stream()
                .map(row -> String.format(format, row.toArray()) + "\n")
                .collect(Collectors.joining());
    }

    private static void collectMaxLengths(int[] maxLengths, List<String> row) {
        IntStream.range(0, row.size())
                .forEach(i -> maxLengths[i] = Math.max(maxLengths[i], row.get(i).length()));
    }

    private static String generateColumnFormat(int[] maxLengths) {
        return Arrays.stream(maxLengths)
                .mapToObj(maxLength -> "%" + (maxLength + 2) + "s" + DELIMITER)
                .collect(Collectors.joining());
    }
}
