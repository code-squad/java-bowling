package view;

import domain.PlayStrategy;
import domain.score.FirstScore;
import domain.score.TotalScore;

import java.util.Scanner;

public class ConsolePlayStrategy implements PlayStrategy {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public FirstScore playFirstScore(int frameNo) {
        System.out.print(frameNo + "프레임 투구 : ");
        int score = scanner.nextInt();
        scanner.nextLine();

        return new FirstScore(score);
    }

    @Override
    public TotalScore playSecondScore(int frameNo, FirstScore firstScore) {
        System.out.print(frameNo + "프레임 투구 : ");
        int score = scanner.nextInt();
        scanner.nextLine();

        return new TotalScore(firstScore, score);
    }
}
