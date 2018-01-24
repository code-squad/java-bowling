package model.frame;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NormalFrameTest {
    private NormalFrame normalFrame;

    @Before
    public void setUp() {
        normalFrame = new NormalFrame(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수값_들어올때_error_쓰로잉() {
        normalFrame.bowl(-1);
    }

    @Test
    public void 프레임의_주어진_기회를_다_사용_하였는가_친구() {
        normalFrame.bowl(2);
        assertThat(normalFrame.isFinished()).isFalse();

        normalFrame.bowl(8);
        assertThat(normalFrame.isFinished()).isTrue();
    }

    @Test
    public void 프레임의_주어진_기회를_스트라이크로_끝내었는가() {
        normalFrame.bowl(10);
        assertThat(normalFrame.isFinished()).isTrue();
    }

    @Test
    public void 프레임_다차고_다음_프레임으로_잘_넘어_가고_있_는_가() {
        normalFrame.bowl(10);
        normalFrame.bowl(2);
        assertThat(normalFrame.getNextFrame().isFinished()).isFalse();

        normalFrame.bowl(4);
        assertThat(normalFrame.getNextFrame().isFinished()).isTrue();
    }

    @Test
    public void missReducerTest(){
        normalFrame.bowl(1);
        normalFrame.bowl(8);
        normalFrame.bowl(1);
        normalFrame.bowl(8);
        int firstFrameScore = normalFrame.getScoreSum();
        int secondFrameScore = normalFrame.getNextFrame().getScoreSum();
        assertThat(firstFrameScore).isEqualTo(9);
        assertThat(secondFrameScore).isEqualTo(9);

    }

    @Test
    public void spareReducerTest(){
        normalFrame.bowl(2);
        normalFrame.bowl(8);
        normalFrame.bowl(1);
        normalFrame.bowl(8);
        int firstFrameScore = normalFrame.getScoreSum();
        int secondFrameScore = normalFrame.getNextFrame().getScoreSum();
        assertThat(firstFrameScore).isEqualTo(11);
        assertThat(secondFrameScore).isEqualTo(9);
    }

    @Test
    public void strikeReducerTest(){
        normalFrame.bowl(10);
        normalFrame.bowl(1);
        normalFrame.bowl(8);
        int firstFrameScore = normalFrame.getScoreSum();
        int secondFrameScore = normalFrame.getNextFrame().getScoreSum();
        assertThat(firstFrameScore).isEqualTo(19);
        assertThat(secondFrameScore).isEqualTo(9);
    }

    @Test
    public void doubleStrikeReducerTest(){
        //FIRST FRAME
        normalFrame.bowl(10);

        //SECOND FRAME
        normalFrame.bowl(10);

        //THIRD FRAME
        normalFrame.bowl(2);
        normalFrame.bowl(2);

        int firstFrameScore = normalFrame.getScoreSum();
        int secondFrameScore = normalFrame.getNextFrame().getScoreSum();
        int thirdFrameScore = normalFrame.getNextFrame().getNextFrame().getScoreSum();

        assertThat(firstFrameScore).isEqualTo(22);
        assertThat(secondFrameScore).isEqualTo(14);
        assertThat(thirdFrameScore).isEqualTo(4);
    }

    @Test
    public void tripleStrikeReducerTest(){
        //FIRST FRAME
        normalFrame.bowl(10);

        //SECOND FRAME
        normalFrame.bowl(10);

        //THIRD FRAME
        normalFrame.bowl(10);

        int firstFrameScore = normalFrame.getScoreSum();
        assertThat(firstFrameScore).isEqualTo(30);
    }

}
