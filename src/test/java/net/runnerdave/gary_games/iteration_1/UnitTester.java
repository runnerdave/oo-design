package net.runnerdave.gary_games.iteration_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 5/12/2016.
 */
public class UnitTester {

    @Test
    public void testCreatingAndPopulatingUnit() {
        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", "25");
        Unit unit1 = new Unit("unit1", UnitType.ARTILLERY, props);
        Assert.assertEquals(unit1.getType(), UnitType.ARTILLERY);

        props = new HashMap<>();
        props.put("hitpoints", "50");
        Unit unit2 = new Unit("unit2", UnitType.TANKS, props);
        Assert.assertEquals(unit2.getType(), UnitType.TANKS);


    }

    @Test
    public void testSetAndGetProperty() {

        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit unit1 = new Unit("unit1", UnitType.ARTILLERY, props);
        Assert.assertEquals(unit1.getType(), UnitType.ARTILLERY);

        Assert.assertEquals(unit1.getProperty("hitpoints"), 25);

        String key = "hitpoints";
        int value = 43;

        unit1.setProperty(key, value);
        Assert.assertEquals(unit1.getProperty("hitpoints"), 43);

        Assert.assertEquals(unit1.getProperty("ddd"), null);
        System.out.println(unit1);
    }
}
