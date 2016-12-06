package net.runnerdave.gary_games.iteration_1;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 5/12/2016.
 */
public class UnitTester {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void testSetAndGetProperty() throws Exception {

        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit unit1 = new Unit("unit1", UnitType.ARTILLERY, props);
        Assert.assertEquals(unit1.getType(), UnitType.ARTILLERY);

        Assert.assertEquals(unit1.getProperty("hitpoints"), 25);

        String key = "hitpoints";
        int value = 43;

        unit1.setProperty(key, value);
        Assert.assertEquals(unit1.getProperty("hitpoints"), 43);

        thrown.expect(Exception.class);
        Assert.assertEquals(unit1.getProperty("ddd"), null);
        System.out.println(unit1);
    }

    @Test
    public void testNullProperty() throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit unit1 = new Unit("unit1", UnitType.ARTILLERY, props);
        thrown.expect(Exception.class);
        unit1.getProperty("non existing");

    }
}
