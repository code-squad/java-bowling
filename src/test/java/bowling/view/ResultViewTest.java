package bowling.view;

import bowling.domain.BowlingGame;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    public void 볼링_게임_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ResultView.print(new BowlingGame("KHG"));

        assertThat(outputStream.toString())
                .isEqualTo(
                        "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n" +
                        "|  KHG |      |      |      |      |      |      |      |      |      |      |\n"
                );
    }
}