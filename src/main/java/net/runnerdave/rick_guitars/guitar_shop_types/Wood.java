package net.runnerdave.rick_guitars.guitar_shop_types;

/**
 * Created by davidajimenez on 23/11/2016.
 */
public enum Wood {
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE,
    COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

    public String toString() {
        switch(this) {
            case INDIAN_ROSEWOOD:    return "Indian Rosewood";
            case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
            case MAHOGANY:           return "Mahogany";
            case MAPLE:              return "Maple";
            case COCOBOLO:           return "Cocobolo";
            case CEDAR:              return "Cedar";
            case ADIRONDACK:         return "Adirondack";
            case ALDER:              return "Alder";
            case SITKA:              return "Sitka";
            default:  return "unspecified";
        }
    }

}
