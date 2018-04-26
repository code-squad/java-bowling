package view;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InputViewTest {
    @Test
    public void userCount() {
        Scanner scanner = new Scanner("2");
        assertEquals(2, InputView.getUserCount(scanner));
    }
}
