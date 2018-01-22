package bowling;

import java.io.InputStream;
import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    private Input(Object value) {
        if(value instanceof InputStream) scanner = new Scanner((InputStream) value);
        else if(value instanceof String) scanner = new Scanner((String) value);
    }

    public static Input generate(Object value) {
        return new Input(value);
    }

    public int getScore() {
        return scanner.nextInt();
    }

    public String getName() {
        return scanner.next();
    }
}
