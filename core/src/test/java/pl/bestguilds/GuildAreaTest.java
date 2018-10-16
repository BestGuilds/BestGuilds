package pl.bestguilds;

import org.junit.Assert;
import org.junit.Test;

public class GuildAreaTest {

    @Test
    public void testConstants() {
        Assert.assertTrue(constants(300, 300, 100, 350, 350));
        Assert.assertTrue(constants(1001, 1001, 100, 901, 901));
        Assert.assertFalse(constants(500, 600, 100, 350, 350));
        Assert.assertFalse(constants(1001, 1001, 99, 901, 901));
    }

    private boolean constants(int x, int z, int size, int x2, int z2) {
        return Math.abs(x - x2) <= size && Math.abs(z - z2) <= size;
    }
}
