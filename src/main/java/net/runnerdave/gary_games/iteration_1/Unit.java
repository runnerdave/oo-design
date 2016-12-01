package net.runnerdave.gary_games.iteration_1;

import java.util.Map;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Unit {
    private String name;
    private UnitType type;
    private Map<String, String> properties;

    public Unit(String name, UnitType type, Map properties) {
        this.name = name;
        this.type = type;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public UnitType getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", properties=" + properties +
                '}';
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
