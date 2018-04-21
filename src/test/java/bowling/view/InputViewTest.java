package bowling.view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 플레이어_이름_입력() {
        String playerName = "KHG";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(playerName.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String actual = InputView.inputPlayerName();

        assertThat(outputStream.toString())
                .isEqualTo("플레이어 이름은(3 english letters)?: ");

        assertThat(actual)
                .isEqualTo(playerName);
    }
}