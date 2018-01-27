package bowling.domain;

import java.util.Optional;

public class BowlingUser {
    private static String name;

    public BowlingUser(Optional<String> name) {
        this.name = name.filter(BowlingUser::isThreeLength).map(String::toUpperCase).orElseThrow(() -> new IllegalArgumentException("이름은 3글자만 허용됩니다."));
    }

    public static BowlingUser registed(Optional<String> name) {
        return new BowlingUser(name);
    }

    private static boolean isThreeLength(String name) {
        return name.length() == 3;
    }

    public static String getName() {
        return name;
    }
}
