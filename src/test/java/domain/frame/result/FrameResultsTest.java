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
        FrameResult aResult = new FrameResult();
        FrameResult sameResult = new FrameResult();
        results.addResult(frame, aResult);
        results.addResult(frame, sameResult);
        assertEquals(1, results.getSavedSize());
    }

    @Test
    public void 다른_프레임_결과_채우기() {
        Frame frame = FrameFactory.of(1);
        FrameResult aResult = new FrameResult();
        Frame antherFrame = FrameFactory.of(2);
        FrameResult anotherResult = new FrameResult();
        results.addResult(frame, aResult);
        results.addResult(antherFrame, anotherResult);
        assertEquals(2, results.getSavedSize());
    }
}