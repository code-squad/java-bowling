package bowling.view;

import java.util.Scanner;

public class Input {


    public static String inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("플레이어의 이름은(3 english letters)?: ");
        return sc.nextLine();
    }

    public static String getName() {
        return inputName();
    }

    public static int inputThrowScore(int frameNum) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print(frameNum + "프레임 투구 :");
        return sc.nextInt();
    }


}
