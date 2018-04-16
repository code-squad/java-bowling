import domain.*;
import view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(InputView.getUserName(scanner));
        List<Frame> frames = new ArrayList<>();
        BowlingGame bowlingGame = new BowlingGame();

        Pins first;
        Pins second;

        first = new Pins(InputView.getThrowing(scanner));
        if (first.isStrike()) {

        }
    }
}