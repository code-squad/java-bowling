package view;

import domain.Frame;

import java.util.Scanner;

public class InputView {

    public static String getName(Scanner scanner) {
        System.out.print("플레이어 이름은(3 english letters)?: ");
        return scanner.nextLine();
    }

    public static int getThrowing(Scanner scanner, Frame frame) {
        if (frame.isFirst()) {
            System.out.print(frame.getFrameNo() + "프레임 투구 : ");
            return scanner.nextInt();
        }
        if (frame.isSecond()) {
            System.out.print(frame.getFrameNo() + "프레임 투구 : ");
            return scanner.nextInt();
        }
        System.out.println(frame.getFrameNo() + "프레임 투구 : ");
        return scanner.nextInt();
    }
}
