package bowling;

public class BowlingUser {
    private String name;

    public BowlingUser(String name) {
        if(isThreeLength(name)) throw new IllegalArgumentException("이름은 3글자만 허용됩니다.");
        this.name = name.toUpperCase();
    }

    public static BowlingUser registed(String name) {
        return new BowlingUser(name);
    }

    private boolean isThreeLength(String name) {
        return name.length() != 3;
    }
}
