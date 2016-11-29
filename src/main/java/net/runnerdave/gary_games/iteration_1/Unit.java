package net.runnerdave.gary_games.iteration_1;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Unit {
    private String name;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Player player;

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
