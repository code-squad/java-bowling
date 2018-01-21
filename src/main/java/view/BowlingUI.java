package view;

import domain.Result;
import java.util.stream.IntStream;

//| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
//|  PJS |      |      |      |      |      |      |      |      |      |      |
public class BowlingUI {
  public static void printResult(String name, Result result) {
    printResultHeader();
    printResultBody(name, result);
  }

  public static void printResultHeader() {
    StringBuilder sb = new StringBuilder();
    sb.append("|  NAME  |");
    IntStream.rangeClosed(1, 10)
        .forEach(i -> {
          sb.append(headerFormat(i));
        });
    System.out.println(sb.toString());
  }

  public static String headerFormat(int i) {
    String frameNumber = i < 10 ? "0" + i : i + "";
    return String.format("  %s  |", frameNumber);
  }

  public static void printResultBody(String name, Result result) {
    StringBuilder sb = new StringBuilder();
    sb.append("|  " + name + "  |");
    IntStream.rangeClosed(1, 10)
        .forEach(i -> {
          sb.append(bodyFormat(result.get(i)));
        });
    System.out.println(sb.toString());
  }

  public static String bodyFormat(String data) {
    return String.format("  %s  |", data);
  }
}
