package bowling.view;

import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

import static bowling.utils.StringUtils.SCORE_INPUT_FORMAT;
import static java.util.Optional.ofNullable;

public class Input {
    private static Scanner scanner;

    private Input(Object value) {
        if(value instanceof InputStream) scanner = new Scanner((InputStream) value);
        else if(value instanceof String) scanner = new Scanner((String) value);
    }

    public static Input generate(Object value) {
        return new Input(value);
    }

    public Optional<Integer> getScore(int frameCount) {
        Output.print(String.format(SCORE_INPUT_FORMAT, frameCount));
        return ofNullable(scanner.nextInt());
    }

    public Optional<String> getName() {
        Output.print("플레이어 이름은(3 english letters)?: ");
        return ofNullable(scanner.next());
    }
}
