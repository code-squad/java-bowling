package view;

import domain.PlayStrategy;
import domain.score.Pin;

import java.util.Scanner;

public class ConsolePlayStrategy implements PlayStrategy {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Pin play(int frameNo) {
        System.out.print(frameNo + "프레임 투구 : ");
        int fallPin = scanner.nextInt();
        scanner.nextLine();

        return new Pin(fallPin);
    }

}
