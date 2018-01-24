import domain.*;
import domain.frame.FinalFrame;
import domain.frame.Frame;
import domain.frame.Frames;
import domain.frame.NormalFrame;

import domain.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BowlingWorker {

  private List<Player> players = new ArrayList<>();
  private Frames frames;

  public Player createBowlGame(String name) {
    frames = new Frames();
    IntStream.rangeClosed(1, 9).forEach(i -> {
      frames.add(new NormalFrame());
    });
    frames.add(new FinalFrame());

    FrameResults results = new FrameResults();
    Player player = new Player(name, results);
    players.add(player);
    return player;
  }

  public FrameResult roll(int round, int pins) {
    Frame frame = frames.get(round);
    frame.roll(new BowlPin(pins));
    FrameResult result = new FrameResult();
    result.addResult(frame.getResult());
    return result;
  }

  public boolean isFrameEnd(int round) {
    Frame frame = frames.get(round);
    return frame.isFrameEnd();
  }
}
