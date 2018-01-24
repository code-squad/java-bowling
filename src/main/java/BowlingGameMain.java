import domain.FrameResult;
import domain.FrameResults;
import view.BowlingCLI;
import view.BowlingUI;

public class BowlingGameMain {

  public static void main(String[] args) {
    String name = BowlingCLI.inputPlayerName();
    BowlingWorker worker = new BowlingWorker();
    worker.createBowlGame(name);

    BowlingUI.printResultHeader();
    BowlingUI.printResultBody(name, new FrameResults());

    int round = 1;
    while (round < 10) {
      int pins = BowlingCLI.inputFrameRoll(round);

     /* FrameResults results = worker.roll(round, pins);
      BowlingUI.printResult("1", results);
      if (worker.isStrike(round)) {
        round++;
        continue;
      }
      round++;*/
    }
  }
}
