package net.runnerdave.gary_games.iteration_1;

import java.util.List;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Tile {
    private int x_coordinate;
    private int y_coordinate;
    private List<Unit> units;

    public Tile(int x_coordinate, int y_coordinate) {

        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public int getX_coordinate() {

        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit u) {
        units.add(u);
    }
}
