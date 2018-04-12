package view;

import domain.Round;
import org.junit.Test;

import static view.ResultView.printRoundState;

public class ResultViewTest {

    @Test
    public void should_print_whole_round_though_under_10_frame() {
        Round round = Round.of();
        round.trying(2); // 1
        round.trying(4);
        round.trying(0); // 2
        round.trying(10);
        printRoundState(round);
    }


    @Test
    public void printScoreTest() {
        Round round = Round.of();
        round.trying(2); // 1
        round.trying(4);
        round.trying(0); // 2
        round.trying(10);
        round.trying(4); // 3
        round.trying(3);
        round.trying(10); // 4
        round.trying(1); // 5
        round.trying(1);
        round.trying(10); // 6
        round.trying(10); // 7
        round.trying(10); // 8
        round.trying(10); // 9
        round.trying(2); // 10
        round.trying(8); // spare
        round.trying(10); // bonus
        System.out.println(round.getRoundFrames().size());
        printRoundState(round);
    }

}