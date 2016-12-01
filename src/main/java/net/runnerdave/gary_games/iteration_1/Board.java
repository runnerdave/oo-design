package net.runnerdave.gary_games.iteration_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Board {
    private int height;
    private int width;
    private List<List<Tile>> tiles;


    public Board(int width, int height) {
        this.height = height;
        this.width = width;
        initialize();
    }

    private void initialize() {
        tiles = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            tiles.add(i, new ArrayList<>(width));
            for (int j = 0; j < width; j++) {
                tiles.get(i).add(new Tile());
            }
        }
    }

    public Tile getTileByPosition(int x, int y) throws Exception {
        if (x >= (width + 1) || y >= (height + 1) || x < 1 || y < 1) {
            throw new Exception("no such position exists");
        }
        return tiles.get(y-1).get(x-1);
    }

    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            List<Tile> row = tiles.get(i);
            for (int j = 0; j < width; j++) {
                sb.append("x:").append(1+j).append(",y:").append(i+1).append(row.get(j).toString()).append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addUnit(Unit u, int x, int y) throws Exception {
        getTileByPosition(x,y).addUnit(u);
    }

    public void removeUnit(Unit u, int x, int y) throws Exception {
        getTileByPosition(x,y).removeUnit(u);
    }
}
