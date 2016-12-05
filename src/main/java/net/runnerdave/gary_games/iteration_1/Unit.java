package net.runnerdave.gary_games.iteration_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by davidajimenez on 30/11/2016.
 */
public class Unit {
    private String name;
    private int id;
    private UnitType type;
    private Map<String, Object> properties;
    private List<Weapon> weapons;

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

    public int getId() {
        return id;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weapon weapon) {
        if (weapons == null) {
            weapons = new LinkedList<>();
        }
        weapons.add(weapon);
    }


    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", properties=" + properties +
                '}';
    }

    public void setProperty(String key, Object value) {
        Object property = properties.get(key);
        if (property != null) {
            properties.put(key, value);
        }

    }

    public Object getProperty(String key) throws Exception {
        if(key == null)
            throw new Exception("key for property cannot be null");
        Object property = properties.get(key);
        if (property == null)
            throw new Exception("property does not exist");
        return property;
    }
}
