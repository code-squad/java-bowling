import model.frame.Frame;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        Frame frame = Frame.of(1);
        frame.bowl(10);
        frame.bowl(2);
        frame.bowl(8);
        ConsoleView.printScoreBoard("foo", frame);
    }
}
