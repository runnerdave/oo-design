package net.runnerdave.gary_games.iteration_1;

import java.util.List;
import java.util.Map;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Game {
    private Map<Integer, Player> players;

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    private Board board;

    public Player battle(Player p1, Player p2) {
        return p1;
    }

    public TerrainType requestTerrain(Tile tile) {
        System.out.println("Terrain requested at " + tile);
        return tile.getTerrain();
    }

    public Game(Map<Integer, Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public List<Unit> requestUnits(Tile tile) {
        return tile.getUnits();

    }
}
