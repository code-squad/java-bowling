package bowling.view;

import java.util.Scanner;

public class InputView {
    public static String getName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("플레이어 이름은(3 english letters)?:");

        return scanner.nextLine();
    }

    public static int getFrameScore(int term){
        Scanner scanner = new Scanner(System.in);
        System.out.print(term+" 프레임 투구: ");

        return scanner.nextInt();
    }
}
