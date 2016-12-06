package net.runnerdave.gary_games.iteration_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 6/12/2016.
 */
public class GroupUnitTester {
    @Test
    public void createGroupUnit() {
        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit u1 = new Unit("u1", 11, UnitType.TANKS, props);

        props = new HashMap<>();
        props.put("hitpoints", "50");
        Unit unit2 = new Unit("unit2", 12, UnitType.TANKS, props);

        GroupUnit gu = new GroupUnit();
        gu.addUnit(u1);
        gu.addUnit(unit2);
        Assert.assertEquals(gu.listUnits().size(), 2);
    }

    @Test
    public void createAndAddAGroupUnit() {
        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit u1 = new Unit("u1", 100, UnitType.TANKS, props);



        GroupUnit gu = new GroupUnit();
        gu.addUnit(u1);
        Assert.assertEquals(gu.listUnits().size(), 1);
    }

    @Test
    public void removeUnitByID() {
        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit u1 = new Unit("u1", 100, UnitType.TANKS, props);



        GroupUnit gu = new GroupUnit();
        gu.addUnit(u1);
        Assert.assertEquals(gu.listUnits().size(), 1);

        Unit result = gu.removeUnit(100);
        Assert.assertEquals(result.getId(), 100);

        Assert.assertEquals(gu.listUnits().size(), 0);
    }

    @Test
    public void removeUnit() {
        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit u1 = new Unit("u1", 100, UnitType.TANKS, props);



        GroupUnit gu = new GroupUnit();
        gu.addUnit(u1);
        Assert.assertEquals(gu.listUnits().size(), 1);

        Unit result = gu.removeUnit(u1);
        Assert.assertEquals(result.getId(), 100);

        Assert.assertEquals(gu.listUnits().size(), 0);
    }

    @Test
    public void getUnitByID() {
        Map<String, Object> props = new HashMap<>();
        props.put("hitpoints", 25);
        Unit u1 = new Unit("u1", 100, UnitType.TANKS, props);



        GroupUnit gu = new GroupUnit();
        gu.addUnit(u1);
        Assert.assertEquals(gu.listUnits().size(), 1);

        Unit result = gu.getUnit(100);
        Assert.assertEquals(result.getId(), 100);

        Assert.assertEquals(gu.listUnits().size(), 1);
    }
}
