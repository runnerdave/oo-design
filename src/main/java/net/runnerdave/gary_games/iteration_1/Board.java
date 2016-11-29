package net.runnerdave.gary_games.iteration_1;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Board {
    private int height;
    private int width;
    private Tile[][] tiles;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(i, j);
                tiles[i][j] = tile;
            }
        }
    }

    public Tile getTileByPosition(int x, int y) throws Exception {
        if (x >= width || y >= height || x < 0 || y < 0) {
            throw new Exception("no such position exists");
        }
        return tiles[x][y];
    }
}
