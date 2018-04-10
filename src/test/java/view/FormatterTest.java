package view;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatterTest {

    @Test
    public void formatString_Name_Frame() {
        String formatString = Formatter.formatFrame("JAE");
        assertEquals("  JAE  ", formatString);
    }

    @Test
    public void formatString_Normal_Frame() {
        String formatString = Formatter.formatFrame("8|/");
        assertEquals("  8|/  ", formatString);
    }

    @Test
    public void formatString_Last_Frame() {
        String formatString = Formatter.formatFrame("X| |X");
        assertEquals("  X| |X", formatString);
    }


}