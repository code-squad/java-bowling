package view;

import domain.FrameResults;
import domain.player.Player;
import java.util.stream.IntStream;

public class BowlingUI {
  public static void printResult(Player player) {
    printResultHeader();
    printResultBody(player.getName(), player.getFrameResults());
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
    return String.format("   %-4s   |", frameNumber);
  }

  public static void printResultBody(String name, FrameResults results) {
    StringBuilder sb = new StringBuilder();
    sb.append("|   " + name + "  |");
    results.getResults().values().stream()
        .forEach(f -> {
          sb.append(bodyFormat(f.getResult()));
        });
    System.out.println(sb.toString());
  }

  public static String bodyFormat(String result) {
    return String.format("   %-4s   |", result);
  }
}
