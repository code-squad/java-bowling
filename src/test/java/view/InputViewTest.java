package view;

import domain.Frame;
import domain.NormalFrame;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InputViewTest {
    Scanner scanner;

    //Todo 사용자 이름 영문 3글자 입력받기
    @Before
    public void setup() {

    }

    @Test
    public void getName() {
        scanner = new Scanner("HTW");
        assertEquals(3, InputView.getName(scanner).length());
    }

    @Test
    public void getFirstThrowing() {
        Frame frame = new NormalFrame();
        scanner = new Scanner("10");
        assertEquals(10, InputView.getThrowing(scanner, frame));
    }
}
