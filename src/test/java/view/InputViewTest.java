package view;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class InputViewTest {
    @Test
    public void userName() {
        Scanner scanner = new Scanner("htw");
        assertEquals("htw", InputView.getUserName(scanner));
    }

    @Test
    public void throwing() {
        Scanner scanner = new Scanner("10");
        assertEquals(10, InputView.getThrowing(scanner, 1));
    }
}
