package net.runnerdave.rick_guitars.guitar_shop;

import net.runnerdave.rick_guitars.guitar_shop_types.Builder;
import net.runnerdave.rick_guitars.guitar_shop_types.Type;
import net.runnerdave.rick_guitars.guitar_shop_types.Wood;

/**
 * Created by davidajimenez on 23/11/2016.
 */
public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type,
                      Wood backWood, Wood topWood, int numStrings) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    @Override
    public String toString() {
        return "GuitarSpec{" +
                "builder=" + builder +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", backWood=" + backWood +
                ", topWood=" + topWood +
                ", numStrings=" + numStrings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        GuitarSpec otherGuitar = (GuitarSpec)o;
        if (otherGuitar.numStrings == this.numStrings &&
                otherGuitar.getBackWood() == this.backWood &&
                otherGuitar.getBuilder() == this.builder &&
                (otherGuitar.getModel() != null && otherGuitar.getModel().equalsIgnoreCase(this.model)) &&
                otherGuitar.topWood == this.topWood &&
                otherGuitar.type == this.type) {
            return true;
        } else {
            return false;
        }
    }
}
