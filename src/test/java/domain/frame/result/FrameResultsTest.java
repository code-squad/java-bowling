package domain.frame.result;

import domain.frame.Frame;
import utils.FrameFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameResultsTest {
    private FrameResults results;

    @Before
    public void setUp() throws Exception {
        results = new FrameResults();
    }

    @Test
    public void 같은_프레임_결과_채우기() {
        Frame frame = FrameFactory.of(1);
        results.addResult(frame, frame.convertScore(5));
        results.addResult(frame, frame.convertScore(4));
        assertEquals(1, results.getSavedSize());
    }

    @Test
    public void 다른_프레임_결과_채우기() {
        Frame frame1 = FrameFactory.of(1);
        Frame frame2 = FrameFactory.of(2);
        results.addResult(frame1, frame1.convertScore(5));
        results.addResult(frame2, frame2.convertScore(3));
        assertEquals(2, results.getSavedSize());
    }
}