package net.runnerdave.gary_games.iteration_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class GameTester {
    public static void main(String[] args) throws Exception {
        System.out.println("== Welcome to Gary's games v1.0 ==");
        Player player1 = new Player(1);
        setupPlayer(player1);
        Player player2 = new Player(2);
        setupPlayer(player2);
        Map<Integer, Player> players = new HashMap<>();
        players.put(player1.getId(), player1);
        players.put(player2.getId(), player2);
        Board board = new Board(10, 10);
        Game game = new Game(players, board);
        System.out.println(game.getBoard().displayBoard());
        System.out.println("== Add unit to a tile ==");
        board.addUnit(player2.getUnitByName("tanks"), 4, 5);
        System.out.println();
        System.out.println(game.getBoard().displayBoard());
    }

    private static void setupPlayer(Player player) {
        Map<String, String> props = new HashMap<>();
        props.put("quantity", "4");
        Unit tanks = new Unit("tanks", UnitType.TANKS, props);
        player.addUnit(tanks);
        Unit army = new Unit("army", UnitType.TROOPS, props);
        player.addUnit(army);
    }
}
