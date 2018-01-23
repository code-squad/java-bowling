package view;

import domain.PlayStrategy;
import domain.score.Score;

import java.util.Scanner;

public class ConsolePlayStrategy implements PlayStrategy {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Score play(int frameNo) {
        System.out.print(frameNo + "프레임 투구 : ");
        int score = scanner.nextInt();
        scanner.nextLine();

        return new Score(score);
    }

}
