import domain.Result;
import view.BowlingCLI;
import view.BowlingUI;

public class BowlingGameMain {

  public static void main(String[] args) {
    String name = BowlingCLI.inputPlayerName();
    BowlingWorker worker = new BowlingWorker();
    worker.createBowlGame(name);

    BowlingUI.printResultHeader();
    BowlingUI.printResultBody(name, new Result());
    int pins = BowlingCLI.inputFrameRoll(1);
    System.out.println("pins = " + pins);

  }
}
