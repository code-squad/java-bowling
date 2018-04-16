package input;

import java.util.Scanner;

public class Input {
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public Integer inputNum(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(i+"프레임 투구 : ");
        return scanner.nextInt();
    }
}
