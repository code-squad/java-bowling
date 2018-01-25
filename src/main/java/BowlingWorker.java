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

  private static final int FRAME_SIZE = 10;
  private List<Player> players = new ArrayList<>();
  private Frames frames;

  public Player createBowlGame(String name) {
    frames = new Frames();
    FrameResults results = new FrameResults();
    IntStream.rangeClosed(1, FRAME_SIZE - 1).forEach(i -> {
      frames.add(new NormalFrame());
      results.add(i, new FrameResult());
    });

    frames.add(new FinalFrame());
    results.add(FRAME_SIZE, new FrameResult());

    Player player = new Player(name, results);
    players.add(player);
    return player;
  }

  public FrameResult roll(int round, int pins) {
    Frame frame = frames.get(round);
    frame.roll(new BowlPin(pins));
    FrameResult result = new FrameResult();
    result.setResult(frame.getResult());
    return result;
  }

  public boolean isFrameEnd(int round) {
    Frame frame = frames.get(round);
    return frame.isFrameEnd();
  }
}
