package tests;

import org.junit.Assert;
import org.junit.Test;
import system.traffic.states.Green;
import system.traffic.LightManager;
import system.traffic.states.Red;
import system.traffic.states.Yellow;

public class LightManagerTest {

    @Test
    public void testLightManagerDefaultState() {
        LightManager lm = new LightManager(null);

        Assert.assertEquals(lm.getState(), Red.getInstance());
    }

    @Test
    public void testLightManagerStates() {
        LightManager lm = new LightManager(Red.getInstance());

        Assert.assertEquals(lm.getState(), Red.getInstance());

        lm.update();

        Assert.assertEquals(lm.getState(), Green.getInstance());

        lm.update();

        Assert.assertEquals(lm.getState(), Yellow.getInstance());

        lm.update();

        Assert.assertEquals(lm.getState(), Red.getInstance());
    }
}
