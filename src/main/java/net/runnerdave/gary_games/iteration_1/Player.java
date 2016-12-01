package net.runnerdave.gary_games.iteration_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Player {
    private int id;

    public Player(int id) {
        this.id = id;
        this.units = new HashMap<>();
    }

    private Map<String, Unit> units;

    public int getId() {
        return id;
    }

    public Unit getUnitByName(String name) {
        return units.get(name);
    }

    public Unit removeUnitFromPlayer(String unitName) {
        return units.remove(unitName);
    }

    public void displayUnits() {
        System.out.println(units);
    }

    public void addUnit(Unit tanks) {
        units.put(tanks.getName(), tanks);
    }
}
