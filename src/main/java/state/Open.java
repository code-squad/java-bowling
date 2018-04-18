package state;

import domain.Pins;

public class Open extends State implements Cloneable{
    private static final String GUTTER = "-";
    private static final String PIPE = "|";

    int first;
    int second;

    public Open(int first, int second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        String first = String.valueOf(this.first);
        String second = String.valueOf(this.second);
        if (this.first == 0) {
            first = GUTTER;
        }
        if (this.second == 0) {
            second = GUTTER;
        }
        return first + PIPE + second;
    }

    @Override
    public State throwing(int throwing) {
        throw new RuntimeException("Open 프레임에서는 더이상 투구할 수 없습니다.");
    }

    public static boolean isOpen(State state) {
        return state instanceof Open;
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
