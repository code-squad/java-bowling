package bowling.dto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CurrentPlayerInfoTest {
    private CurrentPlayerInfo currentPlayerInfo;

    @Before
    public void init() {
        currentPlayerInfo = new CurrentPlayerInfo("kkh", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        new CurrentPlayerInfo("KKH", -1);
    }

    @Test
    public void getNameTest() {
        assertThat(currentPlayerInfo.getName()).isEqualTo("kkh");
    }

    @Test
    public void getCurrentFrameNoTest() {
        assertThat(currentPlayerInfo.getCurrentFrameNo()).isEqualTo(0);
    }
}
