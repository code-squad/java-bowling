//import model.Score;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class RoundScoreTest {
//    private Score roundScore;
//
//    @Before
//    public void setUp() {
//        roundScore = new Score(2);
//
//    }
//
//    @Test
//    public void isStrikeTest() {
//        roundScore.bowl(10);
//        assertThat(roundScore.isStrike()).isTrue();
//    }
//
//    @Test
//    public void 스페어인지_테스트() {
//        roundScore.setPinCount(0,8);
//        roundScore.setPinCount(1, 2);
//        assertThat(roundScore.isSpare()).isTrue();
//    }
//
//    @Test
//    public void getScoreMissTest() {
//        roundScore.setPinCount(0,8);
//        roundScore.setPinCount(1,1);
//
//        int score = roundScore.getScoreSum();
//
//        assertThat(score).isEqualTo(9);
//    }
//}
