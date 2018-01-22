package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CurrentInfoTest {
    private CurrentInfo currentInfo;

    @Before
    public void init() {
        currentInfo = new CurrentInfo("KKH", 0);
    }

    @Test
    public void showCurrentStatusTest() {
        assertThat(currentInfo.showCurrentStatus()).isEqualTo("1프레임 투구 : ");
    }
}
