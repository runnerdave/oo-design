package net.runnerdave.rick_guitars.guitar_shop_types;

/**
 * Created by davidajimenez on 23/11/2016.
 */
public enum Type {
    ACOUSTIC, ELECTRIC;

    public String toString() {
        switch(this) {
            case ACOUSTIC: return "acoustic";
            case ELECTRIC: return "electric";
            default:       return "unspecified";
        }
    }

}
