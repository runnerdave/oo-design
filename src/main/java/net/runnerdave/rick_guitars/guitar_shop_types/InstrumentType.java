package net.runnerdave.rick_guitars.guitar_shop_types;

/**
 * Created by davidajimenez on 27/11/2016.
 */
public enum InstrumentType {
    GUITAR, BANJO, MANDOLIN, FIDDLE, DOBRO, BASS;

    public String toString() {
        switch (this) {
            case GUITAR:
                return "Guitar";
            case BANJO:
                return "Banjo";
            case MANDOLIN:
                return "Mandolin";
            case FIDDLE:
                return "Fiddle";
            case DOBRO:
                return "Dobro";
            case BASS:
                return "Bass";
            default:
                return "unspecified";
        }
    }


}
