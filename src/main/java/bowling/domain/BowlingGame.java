package bowling.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BowlingGame {

    private String playerName;
    private List<Frame> frames;

    public BowlingGame(String playerName) {
        this.playerName = playerName;
        this.frames = new ArrayList<>();
        IntStream
                .rangeClosed(BowlingRule.FIRST_FRAME_NUMBER, BowlingRule.FINAL_FRAME_NUMBER - 1)
                .forEach(index -> frames.add(new NormalFrame()));
        frames.add(new FinalFrame());
    }

    public void play(IntSupplier inputNumberOfPin) {
        System.out.println(toString());

        Iterator iterator = frames.iterator();

        for (int i = 1; iterator.hasNext(); i++) {
            Frame frame = (Frame)iterator.next();
            Iterator frameIterator = frame.iterator();

            while (frameIterator.hasNext()) {
                System.out.println(i + " 프레임 투구 : ");
                ((Frame) frameIterator.next()).shot(inputNumberOfPin.getAsInt(), frameIterator.hasNext());
                System.out.println(toString());
            }
        }
    }

    @Override
    public String toString() {
        String number = IntStream
                .rangeClosed(BowlingRule.FIRST_FRAME_NUMBER, BowlingRule.FINAL_FRAME_NUMBER)
                .mapToObj(i -> String.format("%02d", i))
                .collect(Collectors.joining("  |  "));

        String score = frames
                .stream()
                .map(frame -> StringUtils.defaultIfBlank(frame.toString(), "    "))
                .collect(Collectors.joining(" | "));

        return "| NAME |  "                + number + "  |\n" +
               "|  " + playerName + " | " + score + " |";
    }
}
