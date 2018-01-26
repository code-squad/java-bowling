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
  private List<Player> players;
  private Frames frames;

  public BowlingWorker() {
    this.players = new ArrayList<>();
    this.frames = new Frames();
  }

  public Player createBowlGame(String name) {
    FrameResults results = new FrameResults();
    IntStream.rangeClosed(1, FRAME_SIZE).forEach(i -> {
      results.add(i, new FrameResult());
    });

    Player player = new Player(name, results);
    players.add(player);
    return player;
  }

  public FrameResult roll(int round, int pins) {
    Frame frame = isFinalFrame(round) ? createFinalFrame(round) : createNormalFrame(round);
    frame.roll(new BowlPin(pins));
    FrameResult result = new FrameResult();
    result.setResult(frame.getResult());
    return result;
  }

  public Frame createNormalFrame(int round) {
    if (frames.isFrameExisted(round)) {
      return frames.get(round);
    }

    NormalFrame frame = new NormalFrame();
    frames.add(frame);
    return frame;
  }

  public Frame createFinalFrame(int round) {
    if (frames.isFrameExisted(round)) {
      return frames.get(round);
    }

    FinalFrame frame = new FinalFrame();
    frames.add(frame);
    return frame;
  }

  public boolean isFrameEnd(int round) {
    return frames.isFrameEnd(round);
  }

  private boolean isFinalFrame(int round) {
    return round == 10;
  }
}
