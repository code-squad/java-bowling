package bowling.view;

import bowling.domain.Try;

import java.util.Scanner;

public class InputView {
    public static Try doGame() {
        System.out.print("투구하세요 : ");
        Scanner scanner = new Scanner(System.in);
        return new Try(scanner.nextInt());
    }
}
