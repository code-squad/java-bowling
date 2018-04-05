package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputUtilsTest {

    @Test
    public void 문자열_숫자_숫자변환() {
        assertEquals(10, InputUtils.convertToNumber("10"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자아닌값_숫자변환() {
        InputUtils.convertToNumber("asd");
    }
}
