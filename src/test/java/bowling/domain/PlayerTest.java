package bowling.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void nameSizeTest(){
        Player player = new Player("RiverWay");
    }
}