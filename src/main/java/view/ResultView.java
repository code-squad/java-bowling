package view;

import domain.Frame;
import domain.Round;
import domain.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    static String toStringRoundState(List<Frame> roundFrames) {
        return roundFrames.stream().map(i -> String.format("  %-5s", i.toString()))
                .collect(Collectors.joining("|"));
    }

    static String toStringBlankFrames(int numOfBlankFrames) {
        return "|" + IntStream.range(0, numOfBlankFrames).boxed().map(i -> "       ").collect(Collectors.joining("|"));
    }

    public static void printUserRoundState(User user) {
        System.out.println(String.format("|  %s  |", user.getName())+printRoundState(user.getRound()));
    }

    static String printRoundState(Round round) {
        return toStringRoundState(round.getRoundFrames()) + toStringBlankFrames(11 - round.getRoundFrames().size());
    }

    public static void printMenu() {
        System.out.println("|  NAME |"+IntStream.range(1, 11).boxed().map(i -> String.format("  %02d   ", i)).collect(Collectors.joining("|"))+"|");
    }


}
