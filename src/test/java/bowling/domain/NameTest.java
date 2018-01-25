package bowling.domain;

import org.junit.Test;

public class NameTest {

    @Test(expected = IllegalArgumentException.class)
    public void name_생성_숫자_예외처리() {
        new Name("213");
    }

    @Test(expected = IllegalArgumentException.class)
    public void name_생성_한글_예외처리() {
        new Name("가");
    }

    @Test(expected = IllegalArgumentException.class)
    public void name_생성_특수문자_초과_예외처리() {
        new Name("_");
    }

    @Test(expected = IllegalArgumentException.class)
    public void name_생성_3글자_초과_예외처리() {
        new Name("abcd");
    }

    @Test
    public void name_생성_영문_3글자() {
        new Name("a");
        new Name("ab");
        new Name("abc");
        new Name("Abc");
    }
}
