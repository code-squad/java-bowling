//package domain;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//public class RoundFramesTest {
//
//    RoundFrames roundFrames;
//
//    @Before
//    public void setUp() {
//        roundFrames = RoundFrames.of();
//    }
//
//    @Test
//    public void should_sent_end_message_to_Normal_frame() {
//        roundFrames.presentFrameTry(1);
//        roundFrames.presentFrameTry(2);
//        assertThat(roundFrames.isPresentFrameEnd(), is(true));
//    }
//
//}
