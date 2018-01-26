package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void before() {
        game = game = new BowlingGame();
    }

    @Test
    public void Frame생성() {
        Frame frame = game.getFrames().get(0);
        while(frame.getNextFrame().isPresent()) {
            frame = frame.getNextFrame().get();
        }
        assertThat(game.getFrames().size()).isEqualTo(10);
        assertThat(frame).isInstanceOf(LastFrame.class);
    }

    @Test
    public void 현재몇번째프레임() {
        for (int i = 1; i <= 10; i++) {
            assertThat(game.getCurrentFrameNo()).isEqualTo(i);
            game.throwBall(DownPinCount.STRIKE);
        }
    }

    @Test
    public void 게임종료() {
        for (int i = 0; i < 11; i++) {
            game.throwBall(DownPinCount.STRIKE);
        }
        assertThat(game.isEndGame()).isFalse();
        game.throwBall(DownPinCount.STRIKE);
        assertThat(game.isEndGame()).isTrue();
    }

}