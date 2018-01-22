//import model.frame.NormalFrame;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//public class NormalFrameTest {
//    private NormalFrame normalFrame;
//
//    @Before
//    public void setUp() {
//        normalFrame = new NormalFrame(1);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void 음수값_들어올때_error_쓰로잉() {
//        normalFrame.bowl(-1);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void 점수가_10이상이_들어왔을때_error_스로잉() {
//        normalFrame.bowl(4);
//        normalFrame.bowl(8);
//    }
//
//    @Test
//    public void getScoreStrikeTest() {
//        normalFrame.bowl(10);
//        normalFrame.bowl(6);
//        normalFrame.bowl(2);
//
//        assertThat(normalFrame.getRoundScore()).isEqualTo(18);
//    }
//
//    @Test
//    public void multipleStrikeTest() {
//        normalFrame.bowl(10);
//        normalFrame.bowl(10);
//        normalFrame.bowl(10);
//        normalFrame.bowl(9);
//        assertThat(normalFrame.getRoundScore()).isEqualTo(30);
//    }
//
//}
