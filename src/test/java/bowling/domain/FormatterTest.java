package bowling.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatterTest {

    @Test
    public void formatFrame() {
        assertEquals("8|/   ", Formatter.formatFrame("8|/"));
    }

    @Test
    public void formatFrame_Last_Frame() {
        assertEquals("8|/|5 ", Formatter.formatFrame("8|/|5"));
    }

    @Test
    public void formatLabel() {
        assertEquals("01", Formatter.formatLabel(1));
    }
}