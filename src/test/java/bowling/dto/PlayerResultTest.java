package bowling.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerResultTest {
    private PlayerResult playerResult;

    @Before
    public void init() {
        playerResult = new PlayerResult("KKH", Arrays.asList("   ", "   "), Arrays.asList("   ", "   "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        new PlayerResult("KKH", null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest2() {
        new PlayerResult("KKH", Arrays.asList(), null);
    }

    @Test
    public void getNameTest() {
        assertThat(playerResult.getName()).isEqualTo("KKH");
    }

    @Test
    public void getFrameViewsTest() {
        assertThat(playerResult.getFrameViews()).isEqualTo(Arrays.asList("   ", "   "));
    }
}
