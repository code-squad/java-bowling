package view;

import java.util.Scanner;

//플레이어 이름은(3 english letters)?: PJS
//| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
//|  PJS |      |      |      |      |      |      |      |      |      |      |
//
//1프레임 투구 : 10
//| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
//|  PJS |  X   |      |      |      |      |      |      |      |      |      |
public class BowlingCLI {

  public static String inputPlayerName() {
    return input("플레이어 이름은(3 english letters)?:");
  }

  public static int inputFrameRoll(int round) {
    return Integer.parseInt(input(round + "프레임 투구:"));
  }

  private static String input(String text) {
    Scanner scanner = new Scanner(System.in);
    System.out.print(text);
    return scanner.next();
  }
}
