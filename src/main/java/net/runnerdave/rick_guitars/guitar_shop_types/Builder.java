package net.runnerdave.rick_guitars.guitar_shop_types;

/**
 * Created by davidajimenez on 23/11/2016.
 */
public enum Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    public String toString() {
        switch(this) {
            case FENDER:   return "Fender";
            case MARTIN:   return "Martin";
            case GIBSON:   return "Gibson";
            case COLLINGS: return "Collings";
            case OLSON:    return "Olson";
            case RYAN:     return "Ryan";
            case PRS :     return "PRS";
            default:       return "Unspecified";
        }
    }

}
