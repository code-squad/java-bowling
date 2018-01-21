import domain.Frames;
import java.util.HashMap;
import java.util.Map;

public class BowlingWorker {

  Map<String, Frames> bowlData = new HashMap<>();

  public void createBowlGame(String name) {
    bowlData.put(name, new Frames());
  }

  public void roll(int pins) {

  }
}
