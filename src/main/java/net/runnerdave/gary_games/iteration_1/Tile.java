package net.runnerdave.gary_games.iteration_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Tile {
    private List<Unit> units;

    public TerrainType getTerrain() {
        return terrain;
    }

    public void setTerrain(TerrainType terrain) {
        this.terrain = terrain;
    }

    private TerrainType terrain;

    public Tile() {
        units = new ArrayList<>();
    }


    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit u) {
        units.add(u);
    }

    public void removeUnit(Unit u) {
        units.remove(u);
    }

    @Override
    public String toString() {
        return "{units=" + units +
                ", terrain=" + terrain +
                '}';
    }
}
