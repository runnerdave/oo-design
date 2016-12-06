package net.runnerdave.gary_games.iteration_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by davidajimenez on 6/12/2016.
 */
public class GroupUnit {
    Map<Integer, Unit> group;

    public GroupUnit() {
        group = new HashMap<>();
    }

    public GroupUnit(List<Unit> units) {
        this();
        for (Unit u : units
                ) {
            group.put(u.getId(), u);
        }
    }

    public void addUnit(Unit u) {
        if (group.get(u.getId()) != null) {
            throw new RuntimeException("Unit already in!");
        }
        group.put(u.getId(), u);
    }

    public Unit removeUnit(int uid) {
        if (group.get(uid) == null) {
            throw new RuntimeException("unit not present");
        }
        return group.remove(uid);
    }

    public Unit removeUnit(Unit unit) {
        if (group.get(unit.getId()) == null) {
            throw new RuntimeException("unit not present");
        }
        return group.remove(unit.getId());
    }

    public Unit getUnit(int uid) {
        if (group.get(uid) == null) {
            throw new RuntimeException("unit not present");
        }
        return group.get(uid);
    }

    public List<Unit> listUnits() {
        List<Unit> list = new LinkedList<>();
        group.forEach((k, v) -> list.add(v));
        return list;
    }
}
